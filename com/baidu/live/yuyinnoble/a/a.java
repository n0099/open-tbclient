package com.baidu.live.yuyinnoble.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.df;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.view.YuyinALALevelView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private String bwh;
    private boolean mIsHost;
    private List<df> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.mIsHost = z;
    }

    public void setList(List<df> list) {
        if (this.mList != null) {
            this.mList.clear();
            this.mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mList == null) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0247a c0247a;
        final df dfVar = null;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_item_layout, viewGroup, false);
            c0247a = new C0247a();
            c0247a.cfh = (RelativeLayout) view.findViewById(a.f.ll_container);
            c0247a.bxr = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0247a.bxs = (TextView) view.findViewById(a.f.tv_noble_name);
            c0247a.bxu = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0247a.cfg = (YuyinALALevelView) view.findViewById(a.f.mark_noble);
            a(c0247a.bxr);
            view.setTag(c0247a);
        } else {
            c0247a = (C0247a) view.getTag();
        }
        if (this.mList != null && this.mList.size() > i) {
            dfVar = this.mList.get(i);
        }
        if (dfVar != null) {
            if (c0247a.cfg.getTag() == null || !TextUtils.equals(((df) c0247a.cfg.getTag()).uk, dfVar.uk)) {
                c0247a.bxs.setText(dfVar.aUR);
                c0247a.cfg.setData4Yuyin(dfVar);
                a(dfVar, c0247a.bxr, c0247a.bxu);
                c0247a.cfg.setTag(dfVar);
            }
            c0247a.cfh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        a.this.mTbPageContext.getPageActivity().finish();
                        a.this.a(dfVar);
                    } catch (Exception e) {
                    }
                }
            });
        }
        return view;
    }

    private void a(HeadImageView headImageView) {
        headImageView.setDefaultResource(a.e.sdk_icon_default_avatar100);
        headImageView.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void a(df dfVar, HeadImageView headImageView, ImageView imageView) {
        if (dfVar != null && headImageView != null && imageView != null) {
            headImageView.startLoad(dfVar.aUQ, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (dfVar.aUS == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aUS == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aUS == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aUS == 4) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_earl);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else {
                imageView.setVisibility(8);
                headImageView.setPadding(0, 0, 0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(df dfVar) {
        if (dfVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(dfVar.uk), dfVar.aUR, dfVar.aUQ, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.bwh != null && this.bwh.equals(TbadkCoreApplication.getCurrentAccount()), this.bwh, null, dfVar.aUR, "")));
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0247a {
        public HeadImageView bxr;
        public TextView bxs;
        public ImageView bxu;
        public YuyinALALevelView cfg;
        public RelativeLayout cfh;

        private C0247a() {
        }
    }
}
