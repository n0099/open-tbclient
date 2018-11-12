package com.baidu.searchbox.ng.ai.apps.impl.map.location;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class LocationDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String HIGH_LIGHT_COLOR = "#3C76FF";
    private LocationDetailAdapter mAdapter;
    private LocationItemClickListener mInnerClickListener;
    private TextView mMainTitle;
    private LocationPOIModel mModel;
    private View mSelected;
    private TextView mSubTitle;

    public LocationDetailViewHolder(View view, LocationDetailAdapter locationDetailAdapter, LocationItemClickListener locationItemClickListener) {
        super(view);
        init(view);
        this.mAdapter = locationDetailAdapter;
        this.mInnerClickListener = locationItemClickListener;
    }

    private void init(View view) {
        this.mMainTitle = (TextView) view.findViewById(e.g.main_title);
        this.mSubTitle = (TextView) view.findViewById(e.g.sub_title);
        this.mSelected = view.findViewById(e.g.select);
        this.mSelected.setVisibility(8);
        this.itemView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.mAdapter.resetSelectStatus();
        this.mModel.isSelected = true;
        this.mAdapter.notifyDataSetChanged();
        if (this.mInnerClickListener != null) {
            this.mInnerClickListener.onItemClick(this.mModel);
        }
    }

    public void update(LocationPOIModel locationPOIModel) {
        update(locationPOIModel, null, false);
    }

    public void update(LocationPOIModel locationPOIModel, String str, boolean z) {
        if (locationPOIModel != null) {
            this.mModel = locationPOIModel;
            this.mMainTitle.setText(z ? spanTextColor(locationPOIModel.poiInfo.name, str) : locationPOIModel.poiInfo.name);
            this.mSubTitle.setVisibility(0);
            this.mSubTitle.setText(locationPOIModel.poiInfo.address);
            if (locationPOIModel.isDefaultItem || TextUtils.isEmpty(locationPOIModel.poiInfo.address)) {
                this.mSubTitle.setVisibility(8);
            }
            this.mSelected.setVisibility(locationPOIModel.isSelected ? 0 : 8);
        }
    }

    private CharSequence spanTextColor(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return !TextUtils.isEmpty(str2) ? Html.fromHtml(str.replaceAll(str2, "<font color='#3C76FF'>" + str2 + "</font>")) : str;
    }
}
