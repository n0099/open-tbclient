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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private String bre;
    private boolean mIsHost;
    private List<cz> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bre = str2;
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
        C0240a c0240a;
        final cz czVar = null;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.yuyin_ala_noble_item_layout, viewGroup, false);
            c0240a = new C0240a();
            c0240a.bZB = (RelativeLayout) view.findViewById(a.f.ll_container);
            c0240a.bsn = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0240a.bso = (TextView) view.findViewById(a.f.tv_noble_name);
            c0240a.bsq = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0240a.bZA = (YuyinALALevelView) view.findViewById(a.f.mark_noble);
            a(c0240a.bsn);
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        if (this.mList != null && this.mList.size() > i) {
            czVar = this.mList.get(i);
        }
        if (czVar != null) {
            if (c0240a.bZA.getTag() == null || !TextUtils.equals(((cz) c0240a.bZA.getTag()).uk, czVar.uk)) {
                c0240a.bso.setText(czVar.aQo);
                c0240a.bZA.setData4Yuyin(czVar);
                a(czVar, c0240a.bsn, c0240a.bsq);
                c0240a.bZA.setTag(czVar);
            }
            c0240a.bZB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.yuyinnoble.a.a.1
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
            headImageView.startLoad(czVar.aQn, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (czVar.aQp == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aQp == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aQp == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (czVar.aQp == 4) {
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new YuyinAlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), ExtraParamsManager.getDecryptUserId(czVar.uk), czVar.aQo, czVar.aQn, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.bre != null && this.bre.equals(TbadkCoreApplication.getCurrentAccount()), this.bre, null, czVar.aQo, "")));
        }
    }

    /* renamed from: com.baidu.live.yuyinnoble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0240a {
        public YuyinALALevelView bZA;
        public RelativeLayout bZB;
        public HeadImageView bsn;
        public TextView bso;
        public ImageView bsq;

        private C0240a() {
        }
    }
}
