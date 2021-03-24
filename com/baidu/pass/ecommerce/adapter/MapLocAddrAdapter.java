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
import com.baidu.sapi2.ecommerce.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public class AddrPoiInfoViewHolder extends BaseRecyclerViewHolder<JSONObject> implements View.OnClickListener {
        public TextView addressTv;
        public View bottomLine;
        public ImageView checkedIc;
        public TextView distanceTv;
        public ImageView itemIc;
        public TextView nameTv;

        public AddrPoiInfoViewHolder(@NonNull View view) {
            super(view);
            view.setOnClickListener(this);
            this.itemIc = (ImageView) view.findViewById(R.id.sapi_sdk_addr_map_item_ic);
            this.nameTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_name);
            this.distanceTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_distance);
            this.addressTv = (TextView) view.findViewById(R.id.sapi_sdk_addr_map_item_address);
            this.checkedIc = (ImageView) view.findViewById(R.id.sapi_sdk_addr_map_item_checked_ic);
            this.bottomLine = view.findViewById(R.id.sapi_sdk_addr_map_item_line);
            Resources resources = view.getContext().getResources();
            if (MapLocAddrAdapter.this.isDarkMode) {
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
            if (MapLocAddrAdapter.this.itemClickListener != null) {
                MapLocAddrAdapter.this.itemClickListener.onItemClickListener(this.position, this.t);
            }
            MapLocAddrAdapter.this.notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewHolder
        public void bindData2View(int i, JSONObject jSONObject) {
            super.bindData2View(i, (int) jSONObject);
            String selectedAddrId = MapLocAddrAdapter.this.presenter.getSelectedAddrId();
            if (!TextUtils.isEmpty(selectedAddrId) ? TextUtils.equals(jSONObject.optString(SuggestAddrField.KEY_MAP_ADDRID), selectedAddrId) : false) {
                this.checkedIc.setVisibility(0);
                if (MapLocAddrAdapter.this.isDarkMode) {
                    this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_checked_dark_ic);
                } else {
                    this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_checked_ic);
                }
            } else {
                this.itemView.setBackgroundColor(0);
                if (MapLocAddrAdapter.this.isDarkMode) {
                    this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_no_check_dark_ic);
                } else {
                    this.itemIc.setImageResource(R.drawable.sapi_sdk_addr_map_location_addr_no_check_ic);
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
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.sapi_sdk_color_4e6ff2_dark)), indexOf, MapLocAddrAdapter.this.queryContent.length() + indexOf, 33);
                    } else {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(resources.getColor(R.color.sapi_sdk_color_4e6ff2)), indexOf, MapLocAddrAdapter.this.queryContent.length() + indexOf, 33);
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

    /* loaded from: classes2.dex */
    public class HeaderViewHolder extends BaseRecyclerViewHolder {
        public HeaderViewHolder(@NonNull View view) {
            super(view);
            view.setBackgroundColor(0);
        }
    }

    public MapLocAddrAdapter(MapLocationPoiPresenter mapLocationPoiPresenter, boolean z) {
        this.presenter = mapLocationPoiPresenter;
        this.isDarkMode = z;
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

    @Override // com.baidu.pass.ecommerce.common.adapter.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int i2 = this.headerCount;
        if (i < i2) {
            return 0;
        }
        return (i < i2 || i >= getDataCount() + this.headerCount) ? 2 : 1;
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

    public void setItemClickListener(ScrollRecyclerView.RecyclerViewItemClickListener recyclerViewItemClickListener) {
        this.itemClickListener = recyclerViewItemClickListener;
    }

    public void setQueryContent(String str) {
        this.queryContent = str;
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
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_addr_map_searchbox, viewGroup, false));
        }
        if (i == 1) {
            return new AddrPoiInfoViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_item_address_map, viewGroup, false));
        }
        return new CommonFootViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_sapi_sdk_item_address_map_load_more, viewGroup, false), this.isDarkMode);
    }
}
