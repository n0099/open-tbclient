package com.baidu.live.yuyinnoble.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.cx;
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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private String brl;
    private boolean mIsHost;
    private List<cx> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.brl = str2;
        this.mIsHost = z;
    }

    public void setList(List<cx> list) {
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
        C0248a c0248a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_item_layout, viewGroup, false);
            c0248a = new C0248a();
            c0248a.bXF = (LinearLayout) view.findViewById(a.f.ll_container);
            c0248a.bsq = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0248a.bsr = (TextView) view.findViewById(a.f.tv_noble_name);
            c0248a.bst = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0248a.bXE = (YuyinALALevelView) view.findViewById(a.f.mark_noble);
            a(c0248a.bsq);
            view.setTag(c0248a);
        } else {
            c0248a = (C0248a) view.getTag();
        }
        final cx cxVar = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (cxVar != null) {
            c0248a.bsr.setText(cxVar.aUc);
            c0248a.bXE.setData4Yuyin(cxVar);
            c0248a.bXF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        a.this.mTbPageContext.getPageActivity().finish();
                        a.this.a(cxVar);
                    } catch (Exception e) {
                    }
                }
            });
            a(cxVar, c0248a.bsq, c0248a.bst);
        }
        return view;
    }

    private void a(HeadImageView headImageView) {
        headImageView.setDefaultResource(a.e.sdk_pic_mycenter_avatar_def);
        headImageView.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void a(cx cxVar, HeadImageView headImageView, ImageView imageView) {
        if (cxVar != null && headImageView != null && imageView != null) {
            headImageView.startLoad(cxVar.aUb, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (cxVar.aUd == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (cxVar.aUd == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (cxVar.aUd == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (cxVar.aUd == 4) {
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
    public void a(cx cxVar) {
        if (cxVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(cxVar.uk), cxVar.aUc, cxVar.aUb, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.brl != null && this.brl.equals(TbadkCoreApplication.getCurrentAccount()), this.brl, null, cxVar.aUc, "")));
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0248a {
        public YuyinALALevelView bXE;
        public LinearLayout bXF;
        public HeadImageView bsq;
        public TextView bsr;
        public ImageView bst;

        private C0248a() {
        }
    }
}
