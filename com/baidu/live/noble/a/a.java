package com.baidu.live.noble.a;

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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private String ber;
    private boolean mIsHost;
    private List<com.baidu.live.noble.data.a> mList = new ArrayList();
    private String mLiveId;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext, String str, String str2, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mLiveId = str;
        this.ber = str2;
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
        C0180a c0180a;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_noble_item_layout, (ViewGroup) null);
            c0180a = new C0180a();
            c0180a.bfr = (HeadImageView) view.findViewById(a.g.avatar_noble);
            c0180a.bft = (TextView) view.findViewById(a.g.tv_noble_name);
            c0180a.bfv = (ImageView) view.findViewById(a.g.avatar_noble_wrapper_box);
            c0180a.bfu = (TbImageView) view.findViewById(a.g.mark_noble);
            c0180a.bfu.setDefaultBgResource(a.f.ala_noble_ulist_default_mark_bg);
            a(c0180a.bfr);
            view.setTag(c0180a);
        } else {
            c0180a = (C0180a) view.getTag();
        }
        final com.baidu.live.noble.data.a aVar = (this.mList == null || this.mList.size() <= i) ? null : this.mList.get(i);
        if (aVar != null) {
            c0180a.bft.setText(aVar.bfI);
            c0180a.bfu.startLoad(aVar.icon_url, 10, false);
            c0180a.bfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.live.noble.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    a.this.a(aVar);
                }
            });
            a(aVar, c0180a.bfr, c0180a.bfv);
        }
        return view;
    }

    private void a(HeadImageView headImageView) {
        headImageView.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        headImageView.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        headImageView.setIsRound(true);
        headImageView.setAutoChangeStyle(false);
        headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private void a(com.baidu.live.noble.data.a aVar, HeadImageView headImageView, ImageView imageView) {
        if (aVar != null && headImageView != null && imageView != null) {
            headImageView.startLoad(aVar.bfH, 10, false);
            int dimens = BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds8);
            if (aVar.bfJ == 7) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.f.sdk_pic_noble_avatar_box_king);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.bfJ == 6) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.f.sdk_pic_noble_avatar_box_duke);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.bfJ == 5) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.f.sdk_pic_noble_avatar_box_marquis);
                headImageView.setPadding(dimens, dimens, dimens, dimens);
            } else if (aVar.bfJ == 4) {
                imageView.setVisibility(0);
                imageView.setImageResource(a.f.sdk_pic_noble_avatar_box_earl);
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mTbPageContext.getPageActivity(), aVar.user_id + "", aVar.bfI, aVar.bfH, 0, 0, null, null, 0L, 0L, 0L, 0, null, this.mLiveId, this.ber != null && this.ber.equals(TbadkCoreApplication.getCurrentAccount()), this.ber, null, aVar.bfI, "")));
        }
    }

    /* renamed from: com.baidu.live.noble.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0180a {
        public HeadImageView bfr;
        public TextView bft;
        public TbImageView bfu;
        public ImageView bfv;

        private C0180a() {
        }
    }
}
