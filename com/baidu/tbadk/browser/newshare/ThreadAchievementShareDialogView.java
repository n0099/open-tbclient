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
    private com.baidu.tbadk.core.dialog.a abn;
    private final ThreadAchievementShareInfo evD;
    private Bitmap ewA;
    private View ewB;
    private ImageView ewC;
    private LinearLayout ewD;
    private FrameLayout ewE;
    private HeadImageView ewF;
    private TextView ewG;
    private TextView ewH;
    private FrameLayout ewI;
    private int ewJ;
    private ImageView ewK;
    private Gson ewq;
    private TextView ewr;
    private TextView ews;
    private TextView ewt;
    private TextView ewu;
    private TextView ewv;
    private TextView eww;
    private TextView ewx;
    private TextView ewy;
    private bd ewz;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.ewq = new Gson();
        this.mContext = context;
        this.evD = Ay(str);
    }

    private ThreadAchievementShareInfo Ay(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.ewq.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.abn = aVar;
        initUI(this.mContext);
        if (this.evD.getParams() != null && !y.isEmpty(this.evD.getParams().getThread_list())) {
            this.ewE.addView(new a(this.mContext, this.evD).getView());
            this.ewy.setText(this.evD.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.al("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.ewJ = 2;
        } else if (this.evD.getParams() != null) {
            if (this.evD.getParams().getVideo_info() != null) {
                this.ewE.addView(new c(this.mContext, this.evD).getView());
            } else {
                this.ewE.addView(new b(this.mContext, this.evD).getView());
            }
            this.ewy.setText(this.evD.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.al("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.ewJ = 3;
        }
        bjz();
        return true;
    }

    private void bjz() {
        String user_img;
        if (this.evD != null) {
            ThreadAchievementShareInfo.UserBean user = this.evD.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.ewF.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.ewx.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.evD.getParams().getUrl())) {
                Az(this.evD.getParams().getUrl());
                this.ewC.setVisibility(0);
                return;
            }
            this.ewC.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.ewB = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.ewB, R.drawable.pic_announcement_round);
        this.ewE = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.ewy = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.ewF = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.ewx = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.ewx, R.color.cp_cont_a);
        ap.setViewTextColor(this.ewy, R.color.cp_cont_a);
        this.ewF.setIsRound(true);
        this.ewF.setPlaceHolder(2);
        this.ewF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ewD = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.ewC = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.ewG = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.ewH = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.ewI = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.ewK = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.ewK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.abn != null && ThreadAchievementShareDialogView.this.abn.isShowing()) {
                    ThreadAchievementShareDialogView.this.abn.dismiss();
                }
            }
        });
        ap.setImageResource(this.ewK, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.ewG, R.color.cp_cont_d);
        ap.setViewTextColor(this.ewH, R.color.cp_cont_d);
        ap.setBackgroundColor(this.ewI, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.ewD, R.drawable.bg_frs_private_dialog);
        this.ewr = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.ewr, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.ewr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bjA());
            }
        });
        this.ews = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.ews, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.ews.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bjA(), 3);
            }
        });
        this.ewt = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.ewt, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.ewt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bjA(), 2);
            }
        });
        this.ewu = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.ewu, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.ewu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bjA(), 4);
            }
        });
        this.ewv = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.ewv, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.ewv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bjA(), 8);
            }
        });
        this.eww = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eww, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eww.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bjA(), 6);
            }
        });
    }

    private void Az(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.ewC.setImageBitmap((Bitmap) runTask.getData());
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

    public Bitmap bjA() {
        if (this.ewA == null) {
            ap.setBackgroundColor(this.ewD, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.ewB, R.drawable.pic_announcement);
            this.ewD.buildDrawingCache();
            this.ewA = this.ewD.getDrawingCache();
        }
        ap.setBackgroundResource(this.ewD, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.ewB, R.drawable.pic_announcement_round);
        return this.ewA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bjB()) {
            if (this.ewz == null) {
                this.ewz = new bd(this.mPageContext);
            }
            if (this.evD.getParams() != null && !TextUtils.isEmpty(this.evD.getParams().getUrl())) {
                this.ewz.j(this.evD.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.ewz.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.ewK.performClick();
            aq aqVar = new aq("c13724");
            aqVar.al("obj_type", 1);
            aqVar.al("obj_source", this.ewJ);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bjB() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bjB()) {
            aq aqVar = new aq("c13724");
            if (i == 3) {
                aqVar.al("obj_type", 2);
            } else if (i == 2) {
                aqVar.al("obj_type", 3);
            } else if (i == 8) {
                aqVar.al("obj_type", 4);
            } else if (i == 4) {
                aqVar.al("obj_type", 5);
            } else {
                aqVar.al("obj_type", 6);
            }
            aqVar.al("obj_source", this.ewJ);
            TiebaStatic.log(aqVar);
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bjC */
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
        shareItem.fhj = false;
        shareItem.fhi = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bxw();
        return shareItem;
    }
}
