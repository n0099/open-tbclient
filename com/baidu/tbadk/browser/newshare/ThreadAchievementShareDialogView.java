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
    private com.baidu.tbadk.core.dialog.a aeo;
    public final ThreadAchievementShareInfo eJv;
    private FrameLayout eKA;
    private int eKB;
    private ImageView eKC;
    private Gson eKi;
    private TextView eKj;
    private TextView eKk;
    private TextView eKl;
    private TextView eKm;
    private TextView eKn;
    private TextView eKo;
    private TextView eKp;
    private TextView eKq;
    private at eKr;
    private Bitmap eKs;
    private View eKt;
    private ImageView eKu;
    private LinearLayout eKv;
    private FrameLayout eKw;
    private HeadImageView eKx;
    private TextView eKy;
    private TextView eKz;
    private Context mContext;
    private TbPageContext mPageContext;
    private PermissionJudgePolicy mPermissionJudgement;
    private LinearLayout mRootView;

    public ThreadAchievementShareDialogView(Context context, String str) {
        super(context);
        this.eKi = new Gson();
        this.mContext = context;
        this.eJv = zL(str);
    }

    private ThreadAchievementShareInfo zL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (ThreadAchievementShareInfo) this.eKi.fromJson(str, (Class<Object>) ThreadAchievementShareInfo.class);
    }

    public boolean a(TbPageContext tbPageContext, com.baidu.tbadk.core.dialog.a aVar) {
        this.mPageContext = tbPageContext;
        this.aeo = aVar;
        initUI(this.mContext);
        if (this.eJv.getParams() != null && !y.isEmpty(this.eJv.getParams().getThread_list())) {
            this.eKw.addView(new a(this.mContext, this.eJv).getView());
            this.eKq.setText(this.eJv.getParams().getTitle());
            ar arVar = new ar("c13724");
            arVar.aq("obj_source", 1);
            TiebaStatic.log(arVar);
            this.eKB = 2;
        } else if (this.eJv.getParams() != null) {
            if (this.eJv.getParams().getVideo_info() != null) {
                this.eKw.addView(new c(this.mContext, this.eJv).getView());
            } else {
                this.eKw.addView(new b(this.mContext, this.eJv).getView());
            }
            this.eKq.setText(this.eJv.getParams().getTitle());
            ar arVar2 = new ar(TbadkCoreStatisticKey.WEBVIEW_SHARE);
            arVar2.aq("obj_source", 2);
            TiebaStatic.log(arVar2);
            this.eKB = 3;
        }
        bkN();
        return true;
    }

    private void bkN() {
        String user_img;
        if (this.eJv != null && this.eJv.getParams() != null) {
            ThreadAchievementShareInfo.UserBean user = this.eJv.getParams().getUser();
            if (!TextUtils.isEmpty(user.getImg())) {
                user_img = user.getImg();
            } else {
                user_img = user.getUser_img();
            }
            this.eKx.startLoad("http://tb.himg.baidu.com/sys/portrait/item/" + user_img + ".jpg", 12, false);
            this.eKp.setText(user.getUsername());
            if (!TextUtils.isEmpty(this.eJv.getParams().getUrl())) {
                zM(this.eJv.getParams().getUrl());
                this.eKu.setVisibility(0);
                return;
            }
            this.eKu.setVisibility(8);
        }
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.webview_poster_share, this);
        this.mRootView = (LinearLayout) findViewById(R.id.frs_private_share);
        this.eKt = this.mRootView.findViewById(R.id.poster_head_bg);
        ap.setBackgroundResource(this.mRootView, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eKt, R.drawable.pic_announcement_round);
        this.eKw = (FrameLayout) this.mRootView.findViewById(R.id.poster_container);
        this.eKq = (TextView) this.mRootView.findViewById(R.id.achievement_desc);
        this.eKx = (HeadImageView) this.mRootView.findViewById(R.id.head_portrait);
        this.eKp = (TextView) this.mRootView.findViewById(R.id.user_name);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0101);
        ap.setViewTextColor(this.eKq, R.color.CAM_X0101);
        this.eKx.setIsRound(true);
        this.eKx.setPlaceHolder(2);
        this.eKx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKv = (LinearLayout) this.mRootView.findViewById(R.id.share_view_layout);
        this.eKu = (ImageView) this.mRootView.findViewById(R.id.share_qrcode);
        this.eKy = (TextView) this.mRootView.findViewById(R.id.qrcode_top_desc);
        this.eKz = (TextView) this.mRootView.findViewById(R.id.qrcode_bottom_desc);
        this.eKA = (FrameLayout) this.mRootView.findViewById(R.id.qrcode_layout);
        this.eKC = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.eKC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadAchievementShareDialogView.this.aeo != null && ThreadAchievementShareDialogView.this.aeo.isShowing()) {
                    ThreadAchievementShareDialogView.this.aeo.dismiss();
                }
            }
        });
        ap.setImageResource(this.eKC, R.drawable.icon_popup_shut_n);
        ap.setViewTextColor(this.eKy, R.color.CAM_X0109);
        ap.setViewTextColor(this.eKz, R.color.CAM_X0109);
        ap.setBackgroundColor(this.eKA, R.color.CAM_X0201);
        ap.setBackgroundResource(this.eKv, R.drawable.bg_frs_private_dialog);
        this.eKj = (TextView) this.mRootView.findViewById(R.id.frs_private_share_download);
        a(this.eKj, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.eKj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.t(ThreadAchievementShareDialogView.this.bkO());
            }
        });
        this.eKk = (TextView) this.mRootView.findViewById(R.id.frs_private_share_wechat);
        a(this.eKk, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_wechat40_svg));
        this.eKk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkO(), 3);
            }
        });
        this.eKl = (TextView) this.mRootView.findViewById(R.id.frs_private_share_moment);
        a(this.eKl, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_circle40_svg));
        this.eKl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkO(), 2);
            }
        });
        this.eKm = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qzone);
        a(this.eKm, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qqzone40_svg));
        this.eKm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkO(), 4);
            }
        });
        this.eKn = (TextView) this.mRootView.findViewById(R.id.frs_private_share_qq);
        a(this.eKn, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_qq40_svg));
        this.eKn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkO(), 8);
            }
        });
        this.eKo = (TextView) this.mRootView.findViewById(R.id.frs_private_share_weibo);
        a(this.eKo, new com.baidu.tbadk.core.util.e.b(R.drawable.icon_mask_share_weibo40_svg));
        this.eKo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThreadAchievementShareDialogView.this.d(ThreadAchievementShareDialogView.this.bkO(), 6);
            }
        });
    }

    private void zM(String str) {
        CustomResponsedMessage runTask;
        if (str != null && str.length() != 0 && (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) != null && runTask.getData() != null) {
            this.eKu.setImageBitmap((Bitmap) runTask.getData());
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

    public Bitmap bkO() {
        if (this.eKs == null) {
            ap.setBackgroundColor(this.eKv, R.color.CAM_X0201);
            ap.setBackgroundResource(this.eKt, R.drawable.pic_announcement);
            this.eKv.buildDrawingCache();
            this.eKs = this.eKv.getDrawingCache();
        }
        ap.setBackgroundResource(this.eKv, R.drawable.bg_frs_private_dialog);
        ap.setBackgroundResource(this.eKt, R.drawable.pic_announcement_round);
        return this.eKs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Bitmap bitmap) {
        if (!bkP()) {
            if (this.eKr == null) {
                this.eKr = new at(this.mPageContext);
            }
            if (this.eJv.getParams() != null && !TextUtils.isEmpty(this.eJv.getParams().getUrl())) {
                this.eKr.o(this.eJv.getParams().getUrl(), BitmapHelper.Bitmap2Bytes(bitmap, 100));
            } else {
                this.eKr.o("http://tieba.baidu.com", BitmapHelper.Bitmap2Bytes(bitmap, 100));
            }
            this.eKC.performClick();
            ar arVar = new ar("c13724");
            arVar.aq("obj_type", 1);
            arVar.aq("obj_source", this.eKB);
            TiebaStatic.log(arVar);
        }
    }

    private boolean bkP() {
        if (this.mPermissionJudgement == null) {
            this.mPermissionJudgement = new PermissionJudgePolicy();
        }
        this.mPermissionJudgement.clearRequestPermissionList();
        this.mPermissionJudgement.appendRequestPermission(this.mPageContext.getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
        return this.mPermissionJudgement.startRequestPermission(this.mPageContext.getPageActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final Bitmap bitmap, final int i) {
        if (bitmap != null && !bkP()) {
            ar arVar = new ar("c13724");
            if (i == 3) {
                arVar.aq("obj_type", 2);
            } else if (i == 2) {
                arVar.aq("obj_type", 3);
            } else if (i == 8) {
                arVar.aq("obj_type", 4);
            } else if (i == 4) {
                arVar.aq("obj_type", 5);
            } else {
                arVar.aq("obj_type", 6);
            }
            arVar.aq("obj_source", this.eKB);
            TiebaStatic.log(arVar);
            af.a(new ae<ShareItem>() { // from class: com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView.8
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bkQ */
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
        shareItem.fwJ = false;
        shareItem.fwI = false;
        shareItem.shareType = 1;
        shareItem.title = this.mContext.getString(R.string.app_name);
        shareItem.content = "";
        shareItem.w(bitmap);
        shareItem.bzi();
        return shareItem;
    }
}
