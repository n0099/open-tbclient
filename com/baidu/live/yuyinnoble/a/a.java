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
import com.baidu.live.data.cz;
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
    private String bvS;
    private boolean mIsHost;
    private List<cz> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bvS = str2;
        this.mIsHost = z;
    }

    public void setList(List<cz> list) {
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
        C0249a c0249a;
        final cz czVar = null;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_item_layout, viewGroup, false);
            c0249a = new C0249a();
            c0249a.cer = (RelativeLayout) view.findViewById(a.f.ll_container);
            c0249a.bxb = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0249a.bxc = (TextView) view.findViewById(a.f.tv_noble_name);
            c0249a.bxe = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0249a.ceq = (YuyinALALevelView) view.findViewById(a.f.mark_noble);
            a(c0249a.bxb);
            view.setTag(c0249a);
        } else {
            c0249a = (C0249a) view.getTag();
        }
        if (this.mList != null && this.mList.size() > i) {
            czVar = this.mList.get(i);
        }
        if (czVar != null) {
            if (c0249a.ceq.getTag() == null || !TextUtils.equals(((cz) c0249a.ceq.getTag()).uk, czVar.uk)) {
                c0249a.bxc.setText(czVar.aVb);
                c0249a.ceq.setData4Yuyin(czVar);
                a(czVar, c0249a.bxb, c0249a.bxe);
                c0249a.ceq.setTag(czVar);
            }
            c0249a.cer.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    try {
                        a.this.mTbPageContext.getPageActivity().finish();
                        a.this.a(czVar);
                    } catch (Exception e) {
                    }
                }
            });
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

    private void a(cz czVar, HeadImageView headImageView, ImageView imageView) {
        if (czVar != null && headImageView != null && imageView != null) {
            headImageView.startLoad(czVar.aVa, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (czVar.aVc == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aVc == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aVc == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aVc == 4) {
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
    public void a(cz czVar) {
        if (czVar != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(czVar.uk), czVar.aVb, czVar.aVa, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.bvS != null && this.bvS.equals(TbadkCoreApplication.getCurrentAccount()), this.bvS, null, czVar.aVb, "")));
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0249a {
        public HeadImageView bxb;
        public TextView bxc;
        public ImageView bxe;
        public YuyinALALevelView ceq;
        public RelativeLayout cer;

        private C0249a() {
        }
    }
}
