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
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SuggestAddrListAdapter extends CommonAdapter<JSONObject> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isDarkMode;
    public String queryContent;

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d0523 : invokeV.intValue;
    }

    /* loaded from: classes2.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View bottomLine;
        public final /* synthetic */ SuggestAddrListAdapter this$0;
        public TextView tvAddress;
        public TextView tvName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddrListItemViewHolder(SuggestAddrListAdapter suggestAddrListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {suggestAddrListAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = suggestAddrListAdapter;
            this.tvName = (TextView) findViewById(R.id.obfuscated_res_0x7f091eb5);
            this.tvAddress = (TextView) findViewById(R.id.obfuscated_res_0x7f091eb4);
            this.bottomLine = findViewById(R.id.obfuscated_res_0x7f091eb1);
            Resources resources = view2.getContext().getResources();
            if (suggestAddrListAdapter.isDarkMode) {
                view2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060989));
                this.tvName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609e4));
                this.tvAddress.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f0609e2));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f06097f));
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
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.tvName.getContext().getResources().getColor(R.color.obfuscated_res_0x7f0609ea)), indexOf, this.this$0.queryContent.length() + indexOf, 33);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            return new AddrListItemViewHolder(this, view2);
        }
        return (ViewHolder) invokeL.objValue;
    }

    public void setQueryContent(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.queryContent = str;
        }
    }
}
