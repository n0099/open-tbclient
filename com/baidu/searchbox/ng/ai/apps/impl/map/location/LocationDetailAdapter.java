package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.tieba.e;
import java.util.List;
/* loaded from: classes4.dex */
public class LocationDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_FOOTER = 101;
    private static final int VIEW_TYPE_ITEM = 100;
    private Context mContext;
    private boolean mIsShowFooter;
    private String mKeyWord;
    private LocationItemClickListener mListener;
    private List<LocationPOIModel> mPoiInfos;
    private RecyclerView mRecyclerView;

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, LocationItemClickListener locationItemClickListener, boolean z) {
        this.mRecyclerView = recyclerView;
        this.mContext = context;
        this.mListener = locationItemClickListener;
        this.mIsShowFooter = z;
    }

    public LocationDetailAdapter(Context context, RecyclerView recyclerView, LocationItemClickListener locationItemClickListener) {
        this(context, recyclerView, locationItemClickListener, true);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        switch (i) {
            case 101:
                return new LocationFooterViewHolder(LayoutInflater.from(this.mContext).inflate(e.h.ai_apps_location_footer, viewGroup, false));
            default:
                return new LocationDetailViewHolder(LayoutInflater.from(this.mContext).inflate(e.h.ai_apps_location_item, viewGroup, false), this, this.mListener);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 101:
                ((LocationFooterViewHolder) viewHolder).setVisibility(isScrolled());
                return;
            default:
                ((LocationDetailViewHolder) viewHolder).update(this.mPoiInfos.get(i), this.mKeyWord, isNeedHighLightKeyWord());
                return;
        }
    }

    private boolean isScrolled() {
        return this.mRecyclerView != null && this.mRecyclerView.computeVerticalScrollOffset() > 0;
    }

    public void setData(List<LocationPOIModel> list) {
        setData(list, null);
    }

    public void setData(List<LocationPOIModel> list, String str) {
        if (list != null) {
            this.mPoiInfos = list;
            this.mKeyWord = str;
            notifyDataSetChanged();
        }
    }

    private boolean isNeedHighLightKeyWord() {
        return !TextUtils.isEmpty(this.mKeyWord);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mPoiInfos == null) {
            return 0;
        }
        return (this.mIsShowFooter ? 1 : 0) + this.mPoiInfos.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return (!this.mIsShowFooter || i < getItemCount() + (-1)) ? 100 : 101;
    }

    public void resetSelectStatus() {
        for (LocationPOIModel locationPOIModel : this.mPoiInfos) {
            locationPOIModel.isSelected = false;
        }
    }
}
