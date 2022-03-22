package com.baidu.pass.ecommerce.view.addressdialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter;
import com.baidu.pass.ecommerce.common.mvp.BaseMvpView;
import com.baidu.pass.ecommerce.common.mvp.IBaseView;
import com.baidu.pass.ecommerce.presenter.AddrListPagerPresenter;
import com.baidu.pass.ecommerce.view.addressdialog.ElementNode;
import com.baidu.sapi2.ecommerce.result.AddrSelectorRequestParam;
import com.baidu.sapi2.ecommerce.result.AddressBean;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes4.dex */
public class ListPagerView extends BaseMvpView implements IBaseView, AddrPagerListAdapter.OnAddressSelectedListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int REQUEST_ACTION = 101;
    public static final String REQUEST_PARAM_CHINA = "CHN";
    public static final String REQUEST_PARAM_SORT = "py_init.asc";
    public transient /* synthetic */ FieldHolder $fh;
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

    /* renamed from: com.baidu.pass.ecommerce.view.addressdialog.ListPagerView$1  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-166150910, "Lcom/baidu/pass/ecommerce/view/addressdialog/ListPagerView$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-166150910, "Lcom/baidu/pass/ecommerce/view/addressdialog/ListPagerView$1;");
                    return;
                }
            }
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

    /* loaded from: classes4.dex */
    public interface OnEntitySelectedListener {
        void onEntitySelected(int i, AddressBean addressBean);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListPagerView(@NonNull Context context, int i, OnEntitySelectedListener onEntitySelectedListener) {
        this(context, i, false, onEntitySelectedListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), onEntitySelectedListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Boolean) objArr2[2]).booleanValue(), (OnEntitySelectedListener) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void changeViewStatus(ViewStatus viewStatus, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, this, viewStatus, str) == null) || this.mRecyclerView == null || this.mLoadingView == null || this.mEmptyView == null) {
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$baidu$pass$ecommerce$view$addressdialog$ViewStatus[viewStatus.ordinal()];
        if (i == 1) {
            this.mRecyclerView.setVisibility(0);
            this.mLoadingView.setVisibility(8);
            this.mEmptyView.setVisibility(8);
        } else if (i == 2) {
            this.mRecyclerView.setVisibility(8);
            this.mLoadingView.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.setText(str);
            this.mPagerAddressId = "";
        } else if (i != 3) {
            if (i != 4) {
                return;
            }
            this.mLoadingView.setVisibility(0);
            this.mEmptyView.setVisibility(8);
            this.mEmptyView.setVisibility(8);
        } else {
            this.mRecyclerView.setVisibility(8);
            this.mLoadingView.setVisibility(8);
            this.mEmptyView.setVisibility(0);
            this.mEmptyView.setText("暂无数据");
            this.mPagerAddressId = "";
        }
    }

    private void refershEntity(ElementNode.AddressEntity addressEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, addressEntity) == null) {
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
    }

    private void setEntity2View() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
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
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            AddrListPagerPresenter addrListPagerPresenter = this.mPresenter;
            if (addrListPagerPresenter != null) {
                addrListPagerPresenter.destroy();
            }
            this.mContext = null;
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doFailure(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            changeViewStatus(ViewStatus.ERROR, this.mPresenter.getErrorMsg(i2));
        }
    }

    @Override // com.baidu.pass.ecommerce.common.mvp.IBaseView
    public void doResult(int i, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, obj, str) == null) {
            refershEntity((ElementNode.AddressEntity) obj);
        }
    }

    public String getPagerAddressId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            String str = this.mPagerAddressId;
            return str == null ? "" : str;
        }
        return (String) invokeV.objValue;
    }

    public void loadData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            loadData(REQUEST_PARAM_CHINA);
        }
    }

    @Override // com.baidu.pass.ecommerce.adapter.AddrPagerListAdapter.OnAddressSelectedListener
    public void onAddressSelected(int i, AddressBean addressBean) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048582, this, i, addressBean) == null) || addressBean == null) {
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

    public void setOnEntitySelectedListener(OnEntitySelectedListener onEntitySelectedListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onEntitySelectedListener) == null) {
            this.mOnEntitySelectedListener = onEntitySelectedListener;
        }
    }

    public void setSelectedAddressId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.mSelectedAddressId = str;
        }
    }

    public void setSelectedPositionInfo(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, str, str2, str3) == null) {
            ElementNode.AddressEntity addressEntity = this.mDataEntity;
            addressEntity.selectedId = str;
            addressEntity.selectedName = str2;
            addressEntity.selectedType = str3;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListPagerView(@NonNull Context context, int i, boolean z, OnEntitySelectedListener onEntitySelectedListener) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z), onEntitySelectedListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mPageIndex = i;
        this.mIsDarkMode = z;
        this.mOnEntitySelectedListener = onEntitySelectedListener;
        AddrListPagerPresenter addrListPagerPresenter = new AddrListPagerPresenter();
        this.mPresenter = addrListPagerPresenter;
        addrListPagerPresenter.attachView(this);
        this.mDataEntity = new ElementNode.AddressEntity();
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d04cd, this);
        this.mEmptyView = (TextView) findViewById(R.id.obfuscated_res_0x7f091bde);
        this.mLoadingView = (ProgressBar) findViewById(R.id.obfuscated_res_0x7f091bac);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.obfuscated_res_0x7f091bbf);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.mContext);
        this.mLinearLayoutManager = linearLayoutManager;
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void loadData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.mPagerAddressId = str;
            changeViewStatus(ViewStatus.LOADING, null);
            AddrSelectorRequestParam addrSelectorRequestParam = new AddrSelectorRequestParam();
            addrSelectorRequestParam.setId(str);
            addrSelectorRequestParam.setLeafs("1");
            addrSelectorRequestParam.setSort(REQUEST_PARAM_SORT);
            this.mPresenter.getAddressGetRegion(101, addrSelectorRequestParam);
        }
    }

    public void setSelectedPositionInfo(String str, String str2, String str3, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048587, this, str, str2, str3, i) == null) {
            ElementNode.AddressEntity addressEntity = this.mDataEntity;
            addressEntity.selectedId = str;
            addressEntity.selectedName = str2;
            addressEntity.selectedType = str3;
            addressEntity.selectedPosition = i;
        }
    }

    public void setSelectedPositionInfo(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.mDataEntity.selectedPosition = i;
        }
    }
}
