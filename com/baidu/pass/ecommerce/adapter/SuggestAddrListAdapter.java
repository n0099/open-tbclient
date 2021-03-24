package com.baidu.pass.ecommerce.adapter;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.sapi2.ecommerce.R;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SuggestAddrListAdapter extends CommonAdapter<JSONObject> {
    public boolean isDarkMode;
    public String queryContent;

    /* loaded from: classes2.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> {
        public View bottomLine;
        public TextView tvAddress;
        public TextView tvName;

        public AddrListItemViewHolder(View view) {
            super(view);
            this.tvName = (TextView) findViewById(R.id.sapi_sdk_suggest_map_name);
            this.tvAddress = (TextView) findViewById(R.id.sapi_sdk_suggest_map_address);
            this.bottomLine = findViewById(R.id.sapi_sdk_suggest_addr_bottom_line);
            Resources resources = view.getContext().getResources();
            if (SuggestAddrListAdapter.this.isDarkMode) {
                view.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_suggest_list_layout_bg_dark_color));
                this.tvName.setTextColor(resources.getColor(R.color.sapi_sdk_addr_suggest_list_item_name_text_dark_color));
                this.tvAddress.setTextColor(resources.getColor(R.color.sapi_sdk_addr_suggest_list_item_detail_text_dark_color));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.sapi_sdk_addr_edit_input_bottom_line_bg_dark_color));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            String optString = jSONObject.optString(SuggestAddrField.KEY_MAP_NAME);
            int indexOf = optString.indexOf(SuggestAddrListAdapter.this.queryContent);
            if (indexOf >= 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(optString);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.tvName.getContext().getResources().getColor(R.color.sapi_sdk_color_4e6ff2)), indexOf, SuggestAddrListAdapter.this.queryContent.length() + indexOf, 33);
                this.tvName.setText(spannableStringBuilder);
            } else {
                this.tvName.setText(optString);
            }
            this.tvAddress.setText(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRESS));
        }
    }

    public SuggestAddrListAdapter(boolean z) {
        this.isDarkMode = z;
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public ViewHolder createViewHolder(View view) {
        return new AddrListItemViewHolder(view);
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        return R.layout.layout_sapi_sdk_suggest_addr_item;
    }

    public void setQueryContent(String str) {
        this.queryContent = str;
    }
}
