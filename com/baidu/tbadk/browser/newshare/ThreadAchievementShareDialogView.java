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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.at;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class ThreadAchievementShareDialogView extends LinearLayout {
    private com.baidu.tbadk.core.dialog.a acU;
    public final ThreadAchievementShareInfo eHU;
    private Gson eIH;
    private TextView eII;
    private TextView eIJ;
    private TextView eIK;
    private TextView eIL;
    private TextView eIM;
    private TextView eIN;
    private TextView eIO;
    private TextView eIP;
    private at eIQ;
    private Bitmap eIR;
    private View eIS;
    private ImageView eIT;
    private LinearLayout eIU;
    private FrameLayout eIV;
    private HeadImageView eIW;
    private TextView eIX;
    private TextView eIY;
    private FrameLayout eIZ;
    private int eJa;
    private ImageView eJb;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eIH = new Gson();
        this.mContext = context;
        this.eHU = zE(str);
    }

    private ThreadAchievementShareInfo zE(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eIH.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.acU = aVar;
        initUI(this.mContext);
        if (this.eHU.getParams() != null && !y.isEmpty(this.eHU.getParams().getThread_list())) {
            this.eIV.addView(new a(this.mContext, this.eHU).getView());
            this.eIP.setText(this.eHU.getParams().getTitle());
            ar arVar = new ar("c13724");
            arVar.ap("obj_source", 1);
            TiebaStatic.log(arVar);
            this.eJa = 2;
        } else if (this.eHU.getParams() != null) {
            if (this.eHU.getParams().getVideo_info() != null) {
                this.eIV.addView(new c(this.mContext, this.eHU).getView());
            } else {
                this.eIV.addView(new b(this.mContext, this.eHU).getView());
            }
            this.eIP.setText(this.eHU.getParams().getTitle());
            ar arVar2 = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar2.ap("obj_source", 2);
            TiebaStatic.log(arVar2);
            this.eJa = 3;
        }
        bkL();
        return true;
    }

    private void bkL() {
        String user_img;
        if (this.eHU != null && this.eHU.getParams() != null) {
            ThreadAchievementShareInfo.UserBean user = this.eHU.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eIW.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eIO.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.eHU.getParams().getUrl())) {
                zF(this.eHU.getParams().getUrl());
                this.eIT.setVisibility(0);
                return;
            }
            this.eIT.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eIS = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eIS, R.drawable.pic_announcement_round);
        this.eIV = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eIP = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eIW = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eIO = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIP, R.color.CAM_X0101);
        this.eIW.setIsRound(true);
        this.eIW.setPlaceHolder(2);
        this.eIW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eIU = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eIT = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eIX = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eIY = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eIZ = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eJb = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eJb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.acU != null && ThreadAchievementShareDialogView.this.acU.isShowing()) {
                    ThreadAchievementShareDialogView.this.acU.dismiss();
                }
            }
        });
        ap.setImageResource(this.eJb, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.eIX, R.color.CAM_X0109);
        ap.setViewTextColor(this.eIY, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eIZ, R.color.CAM_X0201);
        ap.setBackgroundResource(this.eIU, R.drawable.bg_frs_private_dialog);
        this.eII = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eII, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eII.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bkM());
            }
        });
        this.eIJ = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eIJ, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eIJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkM(), 3);
            }
        });
        this.eIK = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eIK, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.eIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkM(), 2);
            }
        });
        this.eIL = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eIL, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eIL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkM(), 4);
            }
        });
        this.eIM = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eIM, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.eIM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkM(), 8);
            }
        });
        this.eIN = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eIN, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eIN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkM(), 6);
            }
        });
    }

    private void zF(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eIT.setImageBitmap((Bitmap) runTask.getData());
        }
    }

    private void a(TextView textView, com.baidu.tbadk.core.util.e.a aVar) {
        if (aVar != null) {
            Drawable drawable = aVar.getDrawable();
            int dimens = l.getDimens(getContext(), R.dimen.tbds88);
            drawable.setBounds(0, 0, dimens, dimens);
            textView.setCompoundDrawables(null, drawable, null, null);
            ap.setViewTextColor(textView, R.color.CAM_X0106);
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

    public Bitmap bkM() {
        if (this.eIR == null) {
            ap.setBackgroundColor(this.eIU, R.color.CAM_X0201);
            ap.setBackgroundResource(this.eIS, R.drawable.pic_announcement);
            this.eIU.buildDrawingCache();
            this.eIR = this.eIU.getDrawingCache();
        }
        ap.setBackgroundResource(this.eIU, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eIS, R.drawable.pic_announcement_round);
        return this.eIR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bkN()) {
            if (this.eIQ == null) {
                this.eIQ = new at(this.mPageContext);
            }
            if (this.eHU.getParams() != null && !TextUtils.isEmpty(this.eHU.getParams().getUrl())) {
                this.eIQ.p(this.eHU.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eIQ.p("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eJb.performClick();
            ar arVar = new ar("c13724");
            arVar.ap("obj_type", 1);
            arVar.ap("obj_source", this.eJa);
            TiebaStatic.log(arVar);
        }
    }

    private boolean bkN() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkN()) {
            ar arVar = new ar("c13724");
            if (i == 3) {
                arVar.ap("obj_type", 2);
            } else if (i == 2) {
                arVar.ap("obj_type", 3);
            } else if (i == 8) {
                arVar.ap("obj_type", 4);
            } else if (i == 4) {
                arVar.ap("obj_type", 5);
            } else {
                arVar.ap("obj_type", 6);
            }
            arVar.ap("obj_source", this.eJa);
            TiebaStatic.log(arVar);
            af.a(new ae<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bkO */
                public ShareItem doInBackground() {
                    return ThreadAchievementShareDialogView.this.e(bitmap, i);
                }
            }, new m<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(ShareItem shareItem) {
                    MessageManager.getInstance().sendMessage(new ImplicitShareMessage(ThreadAchievementShareDialogView.this.mContext, i, shareItem, false));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareItem e(Bitmap bitmap, int i) {
        ShareItem shareItem = new ShareItem();
        shareItem.fvk = false;
        shareItem.fvj = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bzf();
        return shareItem;
    }
}
