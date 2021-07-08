package com.baidu.pass.ecommerce.adapter;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter;
import com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder;
import com.baidu.pass.ecommerce.common.adapter.CommonFootViewHolder;
import com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter;
import com.baidu.pass.ecommerce.view.ScrollRecyclerView;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class MapLocAddrAdapter extends BaseRecyclerViewAdapter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ADDR_LOC_TYPE = 1;
    public static final int FOOTER_TYPE = 2;
    public static final int HEADER_TYPE = 0;
    public static final String TAG = "MapLocAddrAdapter";
    public transient /* synthetic */ FieldHolder $fh;
    public List<JSONObject> addrJsonObjs;
    public int footerCount;
    public boolean hasNextPage;
    public int headerCount;
    public boolean isDarkMode;
    public ScrollRecyclerView.RecyclerViewItemClickListener itemClickListener;
    public MapLocationPoiPresenter presenter;
    public String queryContent;

    /* loaded from: classes2.dex */
    public class AddrPoiInfoViewHolder extends BaseRecyclerViewHolder<JSONObject> implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView addressTv;
        public View bottomLine;
        public ImageView checkedIc;
        public TextView distanceTv;
        public ImageView itemIc;
        public TextView nameTv;
        public final /* synthetic */ MapLocAddrAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddrPoiInfoViewHolder(@NonNull MapLocAddrAdapter mapLocAddrAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapLocAddrAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapLocAddrAdapter;
            view.setOnClickListener(this);
            this.itemIc = (ImageView) view.findViewById(R.id.sapi_sdk_addr_map_item_ic);
            this.nameTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_name);
            this.distanceTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_distance);
            this.addressTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_address);
            this.checkedIc = (ImageView) view.findViewById(R.id.sapi_sdk_addr_map_item_checked_ic);
            this.bottomLine = view.findViewById(R.id.sapi_sdk_addr_map_item_line);
            Resources resources = view.getContext().getResources();
            if (mapLocAddrAdapter.isDarkMode) {
                view.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_list_bg_dark_color));
                this.nameTv.setTextColor(resources.getColor(R.color.sapi_sdk_addr_suggest_list_item_name_text_dark_color));
                this.distanceTv.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.addressTv.setTextColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_item_address_py_text_dark_color));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.sapi_sdk_dialog_address_selector_line_dark_color));
                this.checkedIc.setImageResource(R.drawable.sapi_sdk_addr_map_addr_checked_dark_ic);
                view.setBackgroundResource(R.drawable.sapi_sdk_map_addr_item_bg_dark);
                return;
            }
            view.setBackgroundResource(R.drawable.sapi_sdk_map_addr_item_bg);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
                if (this.this$0.itemClickListener != null) {
                    this.this$0.itemClickListener.onItemClickListener(this.position, this.t);
                }
                this.this$0.notifyDataSetChanged();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder
        public void bindData2View(int i2, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, jSONObject) == null) {
                super.bindData2View(i2, (int) jSONObject);
                String selectedAddrId = this.this$0.presenter.getSelectedAddrId();
                if (!TextUtils.isEmpty(selectedAddrId) ? TextUtils.equals(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID), selectedAddrId) : false) {
                    this.checkedIc.setVisibility(0);
                    if (this.this$0.isDarkMode) {
                        this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_checked_dark_ic);
                    } else {
                        this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_checked_ic);
                    }
                } else {
                    this.itemView.setBackgroundColor(0);
                    if (this.this$0.isDarkMode) {
                        this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_no_check_dark_ic);
                    } else {
                        this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_no_check_ic);
                    }
                    this.checkedIc.setVisibility(8);
                }
                String optString = jSONObject.optString(SuggestAddrField.KEY_MAP_NAME);
                if (!TextUtils.isEmpty(this.this$0.queryContent)) {
                    int indexOf = optString.indexOf(this.this$0.queryContent);
                    if (indexOf >= 0) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(optString);
                        Resources resources = this.nameTv.getContext().getResources();
                        if (this.this$0.isDarkMode) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.sapi_sdk_color_4e6ff2_dark)), indexOf, this.this$0.queryContent.length() + indexOf, 33);
                        } else {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.sapi_sdk_color_4e6ff2)), indexOf, this.this$0.queryContent.length() + indexOf, 33);
                        }
                        this.nameTv.setText(spannableStringBuilder);
                    } else {
                        this.nameTv.setText(optString);
                    }
                } else {
                    this.nameTv.setText(optString);
                }
                int optInt = jSONObject.optInt(SuggestAddrField.KEY_MAP_DISTANCE);
                if (optInt < 1000) {
                    TextView textView = this.distanceTv;
                    textView.setText(optInt + "m");
                } else {
                    TextView textView2 = this.distanceTv;
                    textView2.setText(String.format("%.1f", Float.valueOf(optInt / 1000.0f)) + "km");
                }
                this.addressTv.setText(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRESS));
                this.itemView.setOnClickListener(this);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class HeaderViewHolder extends BaseRecyclerViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapLocAddrAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(@NonNull MapLocAddrAdapter mapLocAddrAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapLocAddrAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapLocAddrAdapter;
            view.setBackgroundColor(0);
        }
    }

    public MapLocAddrAdapter(MapLocationPoiPresenter mapLocationPoiPresenter, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mapLocationPoiPresenter, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.headerCount = 1;
        this.footerCount = 1;
        this.hasNextPage = true;
        this.presenter = mapLocationPoiPresenter;
        this.isDarkMode = z;
    }

    private int getDataCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            List<JSONObject> list = this.addrJsonObjs;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void cleanData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            List<JSONObject> list = this.addrJsonObjs;
            if (list == null) {
                this.addrJsonObjs = new ArrayList();
            } else {
                list.clear();
            }
            notifyDataSetChanged();
        }
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (getDataCount() == 0) {
                return 0;
            }
            return this.headerCount + getDataCount() + this.footerCount;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            int i3 = this.headerCount;
            if (i2 < i3) {
                return 0;
            }
            return (i2 < i3 || i2 >= getDataCount() + this.headerCount) ? 2 : 1;
        }
        return invokeI.intValue;
    }

    public void setDatas(List<JSONObject> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, list, z) == null) {
            this.hasNextPage = z;
            List<JSONObject> list2 = this.addrJsonObjs;
            if (list2 == null) {
                this.addrJsonObjs = new ArrayList();
            } else {
                list2.clear();
            }
            this.addrJsonObjs.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void setItemClickListener(ScrollRecyclerView.RecyclerViewItemClickListener recyclerViewItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, recyclerViewItemClickListener) == null) {
            this.itemClickListener = recyclerViewItemClickListener;
        }
    }

    public void setQueryContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.queryContent = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder baseRecyclerViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, baseRecyclerViewHolder, i2) == null) {
            int itemViewType = getItemViewType(i2);
            if (1 == itemViewType) {
                int i3 = i2 - this.headerCount;
                baseRecyclerViewHolder.bindData2View(i3, this.addrJsonObjs.get(i3));
            } else if (2 == itemViewType) {
                baseRecyclerViewHolder.bindData2View(i2, Boolean.valueOf(this.hasNextPage));
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, viewGroup, i2)) == null) {
            if (i2 == 0) {
                return new HeaderViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_addr_map_searchbox, viewGroup, false));
            }
            if (i2 == 1) {
                return new AddrPoiInfoViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_item_address_map, viewGroup, false));
            }
            return new CommonFootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_item_address_map_load_more, viewGroup, false), this.isDarkMode);
        }
        return (BaseRecyclerViewHolder) invokeLI.objValue;
    }
}
