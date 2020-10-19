package com.baidu.tbadk.browser.newshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a abm;
    private Gson ehZ;
    private final ThreadAchievementShareInfo ehm;
    private TextView eia;
    private TextView eib;
    private TextView eic;
    private TextView eid;
    private TextView eie;
    private TextView eif;
    private TextView eig;
    private TextView eih;
    private bd eii;
    private Bitmap eij;
    private View eik;
    private ImageView eil;
    private LinearLayout eim;
    private FrameLayout ein;
    private HeadImageView eio;
    private TextView eip;
    private TextView eiq;
    private FrameLayout eir;
    private int eis;
    private ImageView eit;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.ehZ = new Gson();
        this.mContext = context;
        this.ehm = zR(str);
    }

    private ThreadAchievementShareInfo zR(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.ehZ.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.abm = aVar;
        initUI(this.mContext);
        if (this.ehm.getParams() != null && !y.isEmpty(this.ehm.getParams().getThread_list())) {
            this.ein.addView(new a(this.mContext, this.ehm).getView());
            this.eih.setText(this.ehm.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.aj("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.eis = 2;
        } else if (this.ehm.getParams() != null) {
            if (this.ehm.getParams().getVideo_info() != null) {
                this.ein.addView(new c(this.mContext, this.ehm).getView());
            } else {
                this.ein.addView(new b(this.mContext, this.ehm).getView());
            }
            this.eih.setText(this.ehm.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.aj("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.eis = 3;
        }
        bfg();
        return true;
    }

    private void bfg() {
        String user_img;
        if (this.ehm != null) {
            ThreadAchievementShareInfo.UserBean user = this.ehm.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eio.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eig.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.ehm.getParams().getUrl())) {
                zS(this.ehm.getParams().getUrl());
                this.eil.setVisibility(0);
                return;
            }
            this.eil.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eik = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eik, R.drawable.pic_announcement_round);
        this.ein = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eih = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eio = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eig = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.eig, R.color.cp_cont_a);
        ap.setViewTextColor(this.eih, R.color.cp_cont_a);
        this.eio.setIsRound(true);
        this.eio.setPlaceHolder(2);
        this.eio.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eim = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eil = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eip = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eiq = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eir = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eit = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eit.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.abm != null && ThreadAchievementShareDialogView.this.abm.isShowing()) {
                    ThreadAchievementShareDialogView.this.abm.dismiss();
                }
            }
        });
        ap.setImageResource(this.eit, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.eip, R.color.cp_cont_d);
        ap.setViewTextColor(this.eiq, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eir, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.eim, R.drawable.bg_frs_private_dialog);
        this.eia = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eia, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eia.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bfh());
            }
        });
        this.eib = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eib, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eib.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bfh(), 3);
            }
        });
        this.eic = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eic, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.eic.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bfh(), 2);
            }
        });
        this.eid = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eid, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eid.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bfh(), 4);
            }
        });
        this.eie = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eie, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.eie.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bfh(), 8);
            }
        });
        this.eif = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eif, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eif.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bfh(), 6);
            }
        });
    }

    private void zS(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eil.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.d.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ap.setViewTextColor(textView, R.color.cp_cont_f);
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            layoutParams.width = getTextViewWidth();
            textView.setLayoutParams(layoutParams);
        }
    }

    private int getTextViewWidth() {
        int equipmentWidth;
        int dimens = l.getDimens(this.mContext, R.dimen.tbds44);
        int dimens2 = l.getDimens(this.mContext, R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.mContext) == 2) {
            equipmentWidth = (l.getEquipmentHeight(this.mContext) - (dimens * 2)) - dimens2;
        } else {
            equipmentWidth = (l.getEquipmentWidth(this.mContext) - (dimens * 2)) - dimens2;
        }
        return equipmentWidth / 6;
    }

    public Bitmap bfh() {
        if (this.eij == null) {
            ap.setBackgroundColor(this.eim, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.eik, R.drawable.pic_announcement);
            this.eim.buildDrawingCache();
            this.eij = this.eim.getDrawingCache();
        }
        ap.setBackgroundResource(this.eim, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eik, R.drawable.pic_announcement_round);
        return this.eij;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bfi()) {
            if (this.eii == null) {
                this.eii = new bd(this.mPageContext);
            }
            if (this.ehm.getParams() != null && !TextUtils.isEmpty(this.ehm.getParams().getUrl())) {
                this.eii.j(this.ehm.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eii.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eit.performClick();
            aq aqVar = new aq("c13724");
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_source", this.eis);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bfi() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bfi()) {
            aq aqVar = new aq("c13724");
            if (i == 3) {
                aqVar.aj("obj_type", 2);
            } else if (i == 2) {
                aqVar.aj("obj_type", 3);
            } else if (i == 8) {
                aqVar.aj("obj_type", 4);
            } else if (i == 4) {
                aqVar.aj("obj_type", 5);
            } else {
                aqVar.aj("obj_type", 6);
            }
            aqVar.aj("obj_source", this.eis);
            TiebaStatic.log(aqVar);
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bfj */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: b */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ThreadAchievementShareDialogView.this.mContext, i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.eSW = false;
        shareItem.eSV = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bte();
        return shareItem;
    }
}
