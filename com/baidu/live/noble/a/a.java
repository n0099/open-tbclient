package com.baidu.live.noble.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private String bwh;
    private boolean mIsHost;
    private List<com.baidu.live.noble.data.a> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.bwh = str2;
        this.mIsHost = z;
    }

    public void setList(List<com.baidu.live.noble.data.a> list) {
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
        C0194a c0194a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_noble_item_layout, (ViewGroup) null);
            c0194a = new C0194a();
            c0194a.bxr = (HeadImageView) view.findViewById(a.f.avatar_noble);
            c0194a.bxs = (TextView) view.findViewById(a.f.tv_noble_name);
            c0194a.bxu = (ImageView) view.findViewById(a.f.avatar_noble_wrapper_box);
            c0194a.bxt = (TbImageView) view.findViewById(a.f.mark_noble);
            c0194a.bxt.setDefaultBgResource(a.e.ala_noble_ulist_default_mark_bg);
            a(c0194a.bxr);
            view.setTag(c0194a);
        } else {
            c0194a = (C0194a) view.getTag();
        }
        final com.baidu.live.noble.data.a aVar = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (aVar != null) {
            c0194a.bxs.setText(aVar.aUR);
            if (TextUtils.isEmpty(aVar.icon_url)) {
                c0194a.bxt.setVisibility(4);
            } else {
                c0194a.bxt.setVisibility(0);
                c0194a.bxt.startLoad(aVar.icon_url, 10, false);
            }
            c0194a.bxr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.noble.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.a(aVar);
                }
            });
            a(aVar, c0194a.bxr, c0194a.bxu);
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

    private void a(com.baidu.live.noble.data.a aVar, HeadImageView headImageView, ImageView imageView) {
        if (aVar != null && headImageView != null && imageView != null) {
            headImageView.startLoad(aVar.aUQ, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds8);
            if (aVar.aUS == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.aUS == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.aUS == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.e.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.aUS == 4) {
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
    public void a(com.baidu.live.noble.data.a aVar) {
        if (aVar != null) {
            AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), aVar.user_id + "", aVar.aUR, aVar.aUQ, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.bwh != null && this.bwh.equals(TbadkCoreApplication.getCurrentAccount()), this.bwh, null, aVar.aUR);
            alaPersonCardActivityConfig.setExtInfo(aVar.extInfoJson);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
        }
    }

    /* renamed from: com.baidu.live.noble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0194a {
        public HeadImageView bxr;
        public TextView bxs;
        public TbImageView bxt;
        public ImageView bxu;

        private C0194a() {
        }
    }
}
