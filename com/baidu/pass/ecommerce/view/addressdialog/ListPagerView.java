package com.baidu.pass.ecommerce.view.addressdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter;
import com.baidu.pass.ecommerce.common.mvp.BaseMvpView;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.pass.ecommerce.presenter.AddrListPagerPresenter;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.sapi2.ecommerce.result.AddrSelectorRequestParam;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes3.dex */
public class ListPagerView extends BaseMvpView implements IBaseView, AddrPagerListAdapter.OnAddressSelectedListener {
    public static final int REQUEST_ACTION = 101;
    public static final String REQUEST_PARAM_CHINA = "CHN";
    public static final String REQUEST_PARAM_SORT = "py_init.asc";
    public AddrPagerListAdapter mAdapter;
    public Context mContext;
    public ElementNode.AddressEntity mDataEntity;
    public TextView mEmptyView;
    public boolean mIsDarkMode;
    public LinearLayoutManager mLinearLayoutManager;
    public ProgressBar mLoadingView;
    public OnEntitySelectedListener mOnEntitySelectedListener;
    public int mPageIndex;
    public String mPagerAddressId;
    public AddrListPagerPresenter mPresenter;
    public RecyclerView mRecyclerView;
    public String mSelectedAddressId;

    /* loaded from: classes3.dex */
    public interface OnEntitySelectedListener {
        void onEntitySelected(int i, AddressBean addressBean);
    }

    /* renamed from: com.baidu.pass.ecommerce.view.addressdialog.ListPagerView$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus = iArr;
            try {
                iArr[ViewStatus.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus[ViewStatus.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus[ViewStatus.EMPTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus[ViewStatus.LOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public ListPagerView(@NonNull Context context, int i, OnEntitySelectedListener onEntitySelectedListener) {
        this(context, i, false, onEntitySelectedListener);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        refershEntity((ElementNode.AddressEntity) obj);
    }

    public void setSelectedPositionInfo(String str, String str2, String str3) {
        ElementNode.AddressEntity addressEntity = this.mDataEntity;
        addressEntity.selectedId = str;
        addressEntity.selectedName = str2;
        addressEntity.selectedType = str3;
    }

    public ListPagerView(@NonNull Context context, int i, boolean z, OnEntitySelectedListener onEntitySelectedListener) {
        super(context);
        this.mContext = context;
        this.mPageIndex = i;
        this.mIsDarkMode = z;
        this.mOnEntitySelectedListener = onEntitySelectedListener;
        AddrListPagerPresenter addrListPagerPresenter = new AddrListPagerPresenter();
        this.mPresenter = addrListPagerPresenter;
        addrListPagerPresenter.attachView(this);
        this.mDataEntity = new ElementNode.AddressEntity();
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d056f, this);
        this.mEmptyView = (TextView) findViewById(R.id.obfuscated_res_0x7f092097);
        this.mLoadingView = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f09205e);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f092077);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    private void changeViewStatus(ViewStatus viewStatus, String str) {
        if (this.mRecyclerView != null && this.mLoadingView != null && this.mEmptyView != null) {
            int i = AnonymousClass1.$SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus[viewStatus.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            this.mLoadingView.setVisibility(0);
                            this.mEmptyView.setVisibility(8);
                            this.mEmptyView.setVisibility(8);
                            return;
                        }
                        return;
                    }
                    this.mRecyclerView.setVisibility(8);
                    this.mLoadingView.setVisibility(8);
                    this.mEmptyView.setVisibility(0);
                    this.mEmptyView.setText("暂无数据");
                    this.mPagerAddressId = "";
                    return;
                }
                this.mRecyclerView.setVisibility(8);
                this.mLoadingView.setVisibility(8);
                this.mEmptyView.setVisibility(0);
                this.mEmptyView.setText(str);
                this.mPagerAddressId = "";
                return;
            }
            this.mRecyclerView.setVisibility(0);
            this.mLoadingView.setVisibility(8);
            this.mEmptyView.setVisibility(8);
        }
    }

    private void refershEntity(ElementNode.AddressEntity addressEntity) {
        if (addressEntity == null) {
            changeViewStatus(ViewStatus.EMPTY, null);
            return;
        }
        List<AddressBean> list = addressEntity.list;
        if (list == null || list.isEmpty()) {
            changeViewStatus(ViewStatus.EMPTY, null);
        }
        ElementNode.AddressEntity addressEntity2 = this.mDataEntity;
        addressEntity2.list = list;
        addressEntity2.hotlists = addressEntity.hotlists;
        this.mPresenter.makeSelectedEntity(addressEntity2, this.mSelectedAddressId);
        setEntity2View();
    }

    public void loadData(String str) {
        this.mPagerAddressId = str;
        changeViewStatus(ViewStatus.LOADING, null);
        AddrSelectorRequestParam addrSelectorRequestParam = new AddrSelectorRequestParam();
        addrSelectorRequestParam.setId(str);
        addrSelectorRequestParam.setLeafs("1");
        addrSelectorRequestParam.setSort(REQUEST_PARAM_SORT);
        this.mPresenter.getAddressGetRegion(101, addrSelectorRequestParam);
    }

    public void setOnEntitySelectedListener(OnEntitySelectedListener onEntitySelectedListener) {
        this.mOnEntitySelectedListener = onEntitySelectedListener;
    }

    public void setSelectedAddressId(String str) {
        this.mSelectedAddressId = str;
    }

    public void setSelectedPositionInfo(int i) {
        this.mDataEntity.selectedPosition = i;
    }

    private void setEntity2View() {
        AddrPagerListAdapter addrPagerListAdapter = this.mAdapter;
        if (addrPagerListAdapter == null) {
            AddrPagerListAdapter addrPagerListAdapter2 = new AddrPagerListAdapter(this.mContext, this.mIsDarkMode, this.mDataEntity);
            this.mAdapter = addrPagerListAdapter2;
            addrPagerListAdapter2.setAddressSelectedListener(this);
            this.mRecyclerView.setAdapter(this.mAdapter);
        } else {
            addrPagerListAdapter.setEntity(this.mDataEntity);
            this.mAdapter.notifyDataSetChanged();
        }
        changeViewStatus(ViewStatus.SUCCESS, null);
    }

    public void destroy() {
        AddrListPagerPresenter addrListPagerPresenter = this.mPresenter;
        if (addrListPagerPresenter != null) {
            addrListPagerPresenter.destroy();
        }
        this.mContext = null;
    }

    public String getPagerAddressId() {
        String str = this.mPagerAddressId;
        if (str == null) {
            return "";
        }
        return str;
    }

    public void loadData() {
        loadData(REQUEST_PARAM_CHINA);
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        changeViewStatus(ViewStatus.ERROR, this.mPresenter.getErrorMsg(i2));
    }

    public void setSelectedPositionInfo(String str, String str2, String str3, int i) {
        ElementNode.AddressEntity addressEntity = this.mDataEntity;
        addressEntity.selectedId = str;
        addressEntity.selectedName = str2;
        addressEntity.selectedType = str3;
        addressEntity.selectedPosition = i;
    }

    @Override // com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.OnAddressSelectedListener
    public void onAddressSelected(int i, AddressBean addressBean) {
        if (addressBean == null) {
            return;
        }
        if (i != -1) {
            ElementNode.AddressEntity addressEntity = this.mDataEntity;
            addressEntity.selectedId = addressBean.id;
            addressEntity.selectedName = addressBean.name;
            addressEntity.selectedType = addressBean.type;
            addressEntity.selectedPosition = i;
            this.mAdapter.setHotCityId(null);
        } else {
            this.mAdapter.setHotCityId(addressBean.id);
            ElementNode.AddressEntity addressEntity2 = this.mDataEntity;
            addressEntity2.selectedId = null;
            addressEntity2.selectedName = null;
            addressEntity2.selectedType = null;
            addressEntity2.selectedPosition = 0;
        }
        this.mAdapter.setEntity(this.mDataEntity);
        this.mAdapter.notifyDataSetChanged();
        OnEntitySelectedListener onEntitySelectedListener = this.mOnEntitySelectedListener;
        if (onEntitySelectedListener != null) {
            onEntitySelectedListener.onEntitySelected(this.mPageIndex, addressBean);
        }
    }
}
