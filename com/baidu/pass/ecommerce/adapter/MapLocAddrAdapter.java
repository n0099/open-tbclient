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
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter;
import com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder;
import com.baidu.pass.ecommerce.common.adapter.CommonFootViewHolder;
import com.baidu.pass.ecommerce.presenter.MapLocationPoiPresenter;
import com.baidu.pass.ecommerce.view.ScrollRecyclerView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class MapLocAddrAdapter extends BaseRecyclerViewAdapter {
    public static final int ADDR_LOC_TYPE = 1;
    public static final int FOOTER_TYPE = 2;
    public static final int HEADER_TYPE = 0;
    public static final String TAG = "MapLocAddrAdapter";
    public List<JSONObject> addrJsonObjs;
    public boolean isDarkMode;
    public ScrollRecyclerView.RecyclerViewItemClickListener itemClickListener;
    public MapLocationPoiPresenter presenter;
    public String queryContent;
    public int headerCount = 1;
    public int footerCount = 1;
    public boolean hasNextPage = true;

    /* loaded from: classes3.dex */
    public class AddrPoiInfoViewHolder extends BaseRecyclerViewHolder<JSONObject> implements View.OnClickListener {
        public TextView addressTv;
        public View bottomLine;
        public ImageView checkedIc;
        public TextView distanceTv;
        public ImageView itemIc;
        public TextView nameTv;

        public AddrPoiInfoViewHolder(@NonNull View view2) {
            super(view2);
            view2.setOnClickListener(this);
            this.itemIc = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fa9);
            this.nameTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fab);
            this.distanceTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fa8);
            this.addressTv = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091fa6);
            this.checkedIc = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091fa7);
            this.bottomLine = view2.findViewById(R.id.obfuscated_res_0x7f091faa);
            Resources resources = view2.getContext().getResources();
            if (MapLocAddrAdapter.this.isDarkMode) {
                view2.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f0609c4));
                this.nameTv.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a0f));
                this.distanceTv.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a42));
                this.addressTv.setTextColor(resources.getColor(R.color.obfuscated_res_0x7f060a42));
                this.bottomLine.setBackgroundColor(resources.getColor(R.color.obfuscated_res_0x7f060a4c));
                this.checkedIc.setImageResource(R.drawable.obfuscated_res_0x7f081292);
                view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812fc);
                return;
            }
            view2.setBackgroundResource(R.drawable.obfuscated_res_0x7f0812fb);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder
        public void bindData2View(int i, JSONObject jSONObject) {
            boolean z;
            super.bindData2View(i, (int) jSONObject);
            String selectedAddrId = MapLocAddrAdapter.this.presenter.getSelectedAddrId();
            if (!TextUtils.isEmpty(selectedAddrId)) {
                z = TextUtils.equals(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID), selectedAddrId);
            } else {
                z = false;
            }
            if (z) {
                this.checkedIc.setVisibility(0);
                if (MapLocAddrAdapter.this.isDarkMode) {
                    this.itemIc.setImageResource(R.drawable.obfuscated_res_0x7f081294);
                } else {
                    this.itemIc.setImageResource(R.drawable.obfuscated_res_0x7f081295);
                }
            } else {
                this.itemView.setBackgroundColor(0);
                if (MapLocAddrAdapter.this.isDarkMode) {
                    this.itemIc.setImageResource(R.drawable.obfuscated_res_0x7f081296);
                } else {
                    this.itemIc.setImageResource(R.drawable.obfuscated_res_0x7f081297);
                }
                this.checkedIc.setVisibility(8);
            }
            String optString = jSONObject.optString(SuggestAddrField.KEY_MAP_NAME);
            if (!TextUtils.isEmpty(MapLocAddrAdapter.this.queryContent)) {
                int indexOf = optString.indexOf(MapLocAddrAdapter.this.queryContent);
                if (indexOf >= 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(optString);
                    Resources resources = this.nameTv.getContext().getResources();
                    if (MapLocAddrAdapter.this.isDarkMode) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.obfuscated_res_0x7f060a16)), indexOf, MapLocAddrAdapter.this.queryContent.length() + indexOf, 33);
                    } else {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.obfuscated_res_0x7f060a15)), indexOf, MapLocAddrAdapter.this.queryContent.length() + indexOf, 33);
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (MapLocAddrAdapter.this.itemClickListener != null) {
                MapLocAddrAdapter.this.itemClickListener.onItemClickListener(this.position, this.t);
            }
            MapLocAddrAdapter.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes3.dex */
    public class HeaderViewHolder extends BaseRecyclerViewHolder {
        public HeaderViewHolder(@NonNull View view2) {
            super(view2);
            view2.setBackgroundColor(0);
        }
    }

    public MapLocAddrAdapter(MapLocationPoiPresenter mapLocationPoiPresenter, boolean z) {
        this.presenter = mapLocationPoiPresenter;
        this.isDarkMode = z;
    }

    public void setDatas(List<JSONObject> list, boolean z) {
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

    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.headerCount;
        if (i < i2) {
            return 0;
        }
        if (i >= i2 && i < getDataCount() + this.headerCount) {
            return 1;
        }
        return 2;
    }

    public void setItemClickListener(ScrollRecyclerView.RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.itemClickListener = recyclerViewItemClickListener;
    }

    public void setQueryContent(String str) {
        this.queryContent = str;
    }

    private int getDataCount() {
        List<JSONObject> list = this.addrJsonObjs;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void cleanData() {
        List<JSONObject> list = this.addrJsonObjs;
        if (list == null) {
            this.addrJsonObjs = new ArrayList();
        } else {
            list.clear();
        }
        notifyDataSetChanged();
    }

    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (getDataCount() == 0) {
            return 0;
        }
        return this.headerCount + getDataCount() + this.footerCount;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder baseRecyclerViewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (1 == itemViewType) {
            int i2 = i - this.headerCount;
            baseRecyclerViewHolder.bindData2View(i2, this.addrJsonObjs.get(i2));
        } else if (2 == itemViewType) {
            baseRecyclerViewHolder.bindData2View(i, Boolean.valueOf(this.hasNextPage));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0550, viewGroup, false));
        }
        if (i == 1) {
            return new AddrPoiInfoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0568, viewGroup, false));
        }
        return new CommonFootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0569, viewGroup, false), this.isDarkMode);
    }
}
