package com.baidu.pass.ecommerce.adapter;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.adapter.CommonAdapter;
import com.baidu.pass.ecommerce.common.adapter.ViewHolder;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class SuggestAddrListAdapter extends CommonAdapter<JSONObject> {
    public boolean isDarkMode;
    public String queryContent;

    @Override // com.baidu.pass.ecommerce.common.adapter.CommonAdapter
    public int getItemLayoutId() {
        return R.layout.obfuscated_res_0x7f0d0571;
    }

    /* loaded from: classes3.dex */
    public class AddrListItemViewHolder extends ViewHolder<JSONObject> {
        public View bottomLine;
        public TextView tvAddress;
        public TextView tvName;

        public AddrListItemViewHolder(View view2) {
            super(view2);
            this.tvName = (TextView) findViewById(R.id.obfuscated_res_0x7f091fdb);
            this.tvAddress = (TextView) findViewById(R.id.obfuscated_res_0x7f091fda);
            this.bottomLine = findViewById(R.id.obfuscated_res_0x7f091fd7);
            Resources resources = view2.getContext().getResources();
            if (SuggestAddrListAdapter.this.isDarkMode) {
                view2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0609b2));
                this.tvName.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a0d));
                this.tvAddress.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a0b));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0609a8));
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.ViewHolder
        public void bindView(JSONObject jSONObject) {
            String optString = jSONObject.optString(SuggestAddrField.KEY_MAP_NAME);
            int indexOf = optString.indexOf(SuggestAddrListAdapter.this.queryContent);
            if (indexOf >= 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(optString);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.tvName.getContext().getResources().getColor(R.color.obfuscated_res_0x7f060a13)), indexOf, SuggestAddrListAdapter.this.queryContent.length() + indexOf, 33);
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
    public ViewHolder createViewHolder(View view2) {
        return new AddrListItemViewHolder(view2);
    }

    public void setQueryContent(String str) {
        this.queryContent = str;
    }
}
