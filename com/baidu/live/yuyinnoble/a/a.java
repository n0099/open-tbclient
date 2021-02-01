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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private String buH;
    private boolean mIsHost;
    private List<df> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.buH = str2;
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
        C0241a c0241a;
        final df dfVar = null;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_item_layout, viewGroup, false);
            c0241a = new C0241a();
            c0241a.cdH = (RelativeLayout) view.findViewById(a.f.ll_container);
            c0241a.bvR = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0241a.bvS = (TextView) view.findViewById(a.f.tv_noble_name);
            c0241a.bvU = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0241a.cdG = (YuyinALALevelView) view.findViewById(a.f.mark_noble);
            a(c0241a.bvR);
            view.setTag(c0241a);
        } else {
            c0241a = (C0241a) view.getTag();
        }
        if (this.mList != null && this.mList.size() > i) {
            dfVar = this.mList.get(i);
        }
        if (dfVar != null) {
            if (c0241a.cdG.getTag() == null || !TextUtils.equals(((df) c0241a.cdG.getTag()).uk, dfVar.uk)) {
                c0241a.bvS.setText(dfVar.aTr);
                c0241a.cdG.setData4Yuyin(dfVar);
                a(dfVar, c0241a.bvR, c0241a.bvU);
                c0241a.cdG.setTag(dfVar);
            }
            c0241a.cdH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.a.a.1
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
            headImageView.startLoad(dfVar.aTq, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (dfVar.aTs == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aTs == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aTs == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (dfVar.aTs == 4) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(dfVar.uk), dfVar.aTr, dfVar.aTq, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.buH != null && this.buH.equals(TbadkCoreApplication.getCurrentAccount()), this.buH, null, dfVar.aTr, "")));
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0241a {
        public HeadImageView bvR;
        public TextView bvS;
        public ImageView bvU;
        public YuyinALALevelView cdG;
        public RelativeLayout cdH;

        private C0241a() {
        }
    }
}
