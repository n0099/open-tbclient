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
    private final ThreadAchievementShareInfo epK;
    private TextView eqA;
    private TextView eqB;
    private TextView eqC;
    private TextView eqD;
    private TextView eqE;
    private TextView eqF;
    private bd eqG;
    private Bitmap eqH;
    private View eqI;
    private ImageView eqJ;
    private LinearLayout eqK;
    private FrameLayout eqL;
    private HeadImageView eqM;
    private TextView eqN;
    private TextView eqO;
    private FrameLayout eqP;
    private int eqQ;
    private ImageView eqR;
    private Gson eqx;
    private TextView eqy;
    private TextView eqz;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eqx = new Gson();
        this.mContext = context;
        this.epK = Ak(str);
    }

    private ThreadAchievementShareInfo Ak(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eqx.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.abn = aVar;
        initUI(this.mContext);
        if (this.epK.getParams() != null && !y.isEmpty(this.epK.getParams().getThread_list())) {
            this.eqL.addView(new a(this.mContext, this.epK).getView());
            this.eqF.setText(this.epK.getParams().getTitle());
            aq aqVar = new aq("c13724");
            aqVar.aj("obj_source", 1);
            TiebaStatic.log(aqVar);
            this.eqQ = 2;
        } else if (this.epK.getParams() != null) {
            if (this.epK.getParams().getVideo_info() != null) {
                this.eqL.addView(new c(this.mContext, this.epK).getView());
            } else {
                this.eqL.addView(new b(this.mContext, this.epK).getView());
            }
            this.eqF.setText(this.epK.getParams().getTitle());
            aq aqVar2 = new aq(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            aqVar2.aj("obj_source", 2);
            TiebaStatic.log(aqVar2);
            this.eqQ = 3;
        }
        bgZ();
        return true;
    }

    private void bgZ() {
        String user_img;
        if (this.epK != null) {
            ThreadAchievementShareInfo.UserBean user = this.epK.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eqM.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eqE.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.epK.getParams().getUrl())) {
                Al(this.epK.getParams().getUrl());
                this.eqJ.setVisibility(0);
                return;
            }
            this.eqJ.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eqI = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eqI, R.drawable.pic_announcement_round);
        this.eqL = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eqF = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eqM = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eqE = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a);
        ap.setViewTextColor(this.eqF, R.color.cp_cont_a);
        this.eqM.setIsRound(true);
        this.eqM.setPlaceHolder(2);
        this.eqM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eqK = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eqJ = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eqN = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eqO = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eqP = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eqR = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eqR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.abn != null && ThreadAchievementShareDialogView.this.abn.isShowing()) {
                    ThreadAchievementShareDialogView.this.abn.dismiss();
                }
            }
        });
        ap.setImageResource(this.eqR, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.eqN, R.color.cp_cont_d);
        ap.setViewTextColor(this.eqO, R.color.cp_cont_d);
        ap.setBackgroundColor(this.eqP, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.eqK, R.drawable.bg_frs_private_dialog);
        this.eqy = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eqy, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eqy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bha());
            }
        });
        this.eqz = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eqz, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eqz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bha(), 3);
            }
        });
        this.eqA = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eqA, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_circle40_svg));
        this.eqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bha(), 2);
            }
        });
        this.eqB = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eqB, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bha(), 4);
            }
        });
        this.eqC = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eqC, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_qq40_svg));
        this.eqC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bha(), 8);
            }
        });
        this.eqD = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eqD, new com.baidu.tbadk.core.util.d.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eqD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bha(), 6);
            }
        });
    }

    private void Al(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eqJ.setImageBitmap((Bitmap) runTask.getData());
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

    public Bitmap bha() {
        if (this.eqH == null) {
            ap.setBackgroundColor(this.eqK, R.color.cp_bg_line_d);
            ap.setBackgroundResource(this.eqI, R.drawable.pic_announcement);
            this.eqK.buildDrawingCache();
            this.eqH = this.eqK.getDrawingCache();
        }
        ap.setBackgroundResource(this.eqK, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eqI, R.drawable.pic_announcement_round);
        return this.eqH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bhb()) {
            if (this.eqG == null) {
                this.eqG = new bd(this.mPageContext);
            }
            if (this.epK.getParams() != null && !TextUtils.isEmpty(this.epK.getParams().getUrl())) {
                this.eqG.j(this.epK.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eqG.j("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eqR.performClick();
            aq aqVar = new aq("c13724");
            aqVar.aj("obj_type", 1);
            aqVar.aj("obj_source", this.eqQ);
            TiebaStatic.log(aqVar);
        }
    }

    private boolean bhb() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bhb()) {
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
            aqVar.aj("obj_source", this.eqQ);
            TiebaStatic.log(aqVar);
            ae.a(new ad<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bhc */
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
        shareItem.fbs = false;
        shareItem.fbr = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.buX();
        return shareItem;
    }
}
