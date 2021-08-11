package com.baidu.pass.ecommerce.adapter;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.sapi2.ecommerce.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class SuggestAddrListAdapter extends CommonAdapter<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public String queryContent;

    /* loaded from: classes5.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View bottomLine;
        public final /* synthetic */ SuggestAddrListAdapter this$0;
        public TextView tvAddress;
        public TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddrListItemViewHolder(SuggestAddrListAdapter suggestAddrListAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suggestAddrListAdapter, view};
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
            this.this$0 = suggestAddrListAdapter;
            this.tvName = (TextView) findViewById(R.id.sapi_sdk_suggest_map_name);
            this.tvAddress = (TextView) findViewById(R.id.sapi_sdk_suggest_map_address);
            this.bottomLine = findViewById(R.id.sapi_sdk_suggest_addr_bottom_line);
            Resources resources = view.getContext().getResources();
            if (suggestAddrListAdapter.isDarkMode) {
                view.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_suggest_list_layout_bg_dark_color));
                this.tvName.setTextColor(resources.getColor(R.color.sapi_sdk_addr_suggest_list_item_name_text_dark_color));
                this.tvAddress.setTextColor(resources.getColor(R.color.sapi_sdk_addr_suggest_list_item_detail_text_dark_color));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                String optString = jSONObject.optString(SuggestAddrField.KEY_MAP_NAME);
                int indexOf = optString.indexOf(this.this$0.queryContent);
                if (indexOf >= 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(optString);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.tvName.getContext().getResources().getColor(R.color.sapi_sdk_color_4e6ff2)), indexOf, this.this$0.queryContent.length() + indexOf, 33);
                    this.tvName.setText(spannableStringBuilder);
                } else {
                    this.tvName.setText(optString);
                }
                this.tvAddress.setText(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRESS));
            }
        }
    }

    public SuggestAddrListAdapter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? new AddrListItemViewHolder(this, view) : (ViewHolder) invokeL.objValue;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.layout_sapi_sdk_suggest_addr_item : invokeV.intValue;
    }

    public void setQueryContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.queryContent = str;
        }
    }
}
