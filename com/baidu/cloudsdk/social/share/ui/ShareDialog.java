package com.baidu.cloudsdk.social.share.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ShareDialog extends Dialog implements aj {
    protected static final int MAX_LENGTH_FOR_OTHERS = 140;
    protected static final int MAX_LENGTH_FOR_QZONE = 80;
    private static final String a = ShareDialog.class.getSimpleName();
    private static final ViewGroup.LayoutParams b = new ViewGroup.LayoutParams(-1, -1);
    public static TextView mCounterView;
    private m c;
    private ShareContent d;
    private String e;
    private boolean f;
    private boolean g;
    private MediaType h;
    private Handler i;
    private Context j;
    protected IBaiduListener mListener;
    public int mMaxLength;
    protected LinearLayout mRootLayout;
    protected List mShareMediaItems;
    protected SocialShareConfig mSocialShareConfig;

    public ShareDialog(Context context, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this(context, shareContent, null, iBaiduListener);
    }

    public ShareDialog(Context context, ShareContent shareContent, MediaType mediaType, IBaiduListener iBaiduListener) {
        super(context, 16973837);
        this.f = false;
        this.i = new Handler();
        if (context instanceof Activity) {
            ((Activity) context).setRequestedOrientation(1);
        }
        this.j = context;
        this.d = shareContent;
        this.e = shareContent.getContent();
        this.mListener = iBaiduListener;
        this.mSocialShareConfig = SocialShareConfig.getInstance(context);
        this.g = this.mSocialShareConfig.getInt("use_toast_tip") != 0;
        this.h = mediaType;
        this.mMaxLength = this.h == MediaType.QZONE ? 80 : MAX_LENGTH_FOR_OTHERS;
        this.mRootLayout = new LinearLayout(context);
        this.mRootLayout.setOrientation(1);
        this.mRootLayout.setBackgroundColor(-592138);
        this.mRootLayout.setFocusable(true);
        this.mRootLayout.setFocusableInTouchMode(true);
        setContentView(this.mRootLayout, b);
        this.mRootLayout.addView(a(context), new LinearLayout.LayoutParams(-1, DrawableUtils.fix720px(context, 90)));
        int fix720px = DrawableUtils.fix720px(context, 347);
        int fix720px2 = DrawableUtils.fix720px(context, 34);
        int fix720px3 = DrawableUtils.fix720px(context, 24);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, fix720px);
        layoutParams.setMargins(fix720px2, fix720px3, fix720px2, 0);
        this.mRootLayout.addView(b(context), layoutParams);
        int fix720px4 = DrawableUtils.fix720px(context, 72);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(fix720px2, fix720px4, fix720px2, 0);
        this.mRootLayout.addView(c(context), layoutParams2);
    }

    private GradientDrawable a(Context context, int i) {
        float fix720px = DrawableUtils.fix720px(context, 20);
        float[] fArr = {fix720px, fix720px, fix720px, fix720px, fix720px, fix720px, fix720px, fix720px};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{i, i});
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(1, -1644826);
        gradientDrawable.setGradientRadius((float) (Math.sqrt(2.0d) * 60.0d));
        gradientDrawable.setCornerRadii(fArr);
        return gradientDrawable;
    }

    private View a(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundDrawable(DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("titlebar_bg")));
        int fix720px = DrawableUtils.fix720px(context, 30);
        Drawable drawable = DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("titlebar_btn"));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("titlebar_btn_mask"))});
        Button button = new Button(context);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, layerDrawable);
        stateListDrawable.addState(new int[0], drawable);
        button.setBackgroundDrawable(stateListDrawable);
        button.setText(this.mSocialShareConfig.getString("cancel"));
        button.setTextSize(0, fix720px);
        button.setTextColor(-13487566);
        button.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
        button.setGravity(17);
        button.setId(1);
        button.setOnClickListener(new t(this));
        int fix720px2 = DrawableUtils.fix720px(context, 34);
        int fix720px3 = DrawableUtils.fix720px(context, SocialAPIErrorCodes.ERROR_SESSION_EXPIRED);
        int fix720px4 = DrawableUtils.fix720px(context, 65);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fix720px3, fix720px4);
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = fix720px2;
        relativeLayout.addView(button, layoutParams);
        Button button2 = new Button(context);
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        stateListDrawable2.addState(new int[]{16842919}, layerDrawable);
        stateListDrawable2.addState(new int[0], drawable);
        button2.setBackgroundDrawable(stateListDrawable2);
        button2.setText(this.mSocialShareConfig.getString("share"));
        button2.setTextSize(0, fix720px);
        button2.setTextColor(-13487566);
        button2.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
        button2.setGravity(17);
        button2.setId(2);
        button2.setOnClickListener(new v(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(fix720px3, fix720px4);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = fix720px2;
        relativeLayout.addView(button2, layoutParams2);
        int fix720px5 = DrawableUtils.fix720px(context, 34);
        TextView textView = new TextView(context);
        textView.setTextSize(0, fix720px5);
        textView.setTextColor(-13487566);
        textView.setShadowLayer(1.0f, 0.0f, 1.0f, -1);
        textView.setText(this.mSocialShareConfig.getString("sharecontent"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        relativeLayout.addView(textView, layoutParams3);
        return relativeLayout;
    }

    private void a() {
        Log.d(a, "showToast");
        Context context = getContext();
        Drawable drawable = DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("tip_words"));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundDrawable(drawable);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int fix720px = DrawableUtils.fix720px(context, 22);
        TextView textView = new TextView(context);
        textView.setText(this.mSocialShareConfig.getString("qzone_limit_tip"));
        textView.setTextColor(-1);
        textView.setTextSize(0, DrawableUtils.fix720px(context, 22));
        textView.setGravity(17);
        textView.setPadding(fix720px, 0, fix720px, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        this.i.postDelayed(new ad(this, linearLayout), 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        Context context = getContext();
        if (this.g) {
            Toast.makeText(context, this.mSocialShareConfig.getString(str), 0).show();
        } else {
            new AlertDialog.Builder(context).setTitle(this.mSocialShareConfig.getString("tip_title")).setMessage(this.mSocialShareConfig.getString(str)).setPositiveButton(this.mSocialShareConfig.getString("confirm"), (DialogInterface.OnClickListener) null).show();
        }
    }

    private View b(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundDrawable(DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("editor_bg")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, DrawableUtils.fix720px(context, 300));
        layoutParams.addRule(0, 9);
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        relativeLayout.addView(d(context), layoutParams);
        if (this.d.getImageData() != null || this.d.getImageUri() != null) {
            int fix720px = DrawableUtils.fix720px(context, 18);
            int fix720px2 = DrawableUtils.fix720px(context, 20);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DrawableUtils.fix720px(context, 126), DrawableUtils.fix720px(context, 155));
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
            layoutParams2.setMargins(0, fix720px2, fix720px, 0);
            relativeLayout.addView(g(context), layoutParams2);
        }
        int fix720px3 = DrawableUtils.fix720px(context, 38);
        int fix720px4 = DrawableUtils.fix720px(context, 18);
        int fix720px5 = DrawableUtils.fix720px(context, 8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, fix720px3);
        layoutParams3.addRule(9);
        layoutParams3.addRule(12);
        layoutParams3.bottomMargin = fix720px5;
        layoutParams3.leftMargin = fix720px4;
        this.c = e(context);
        relativeLayout.addView(this.c, layoutParams3);
        int fix720px6 = DrawableUtils.fix720px(context, 74);
        int fix720px7 = DrawableUtils.fix720px(context, 38);
        int fix720px8 = DrawableUtils.fix720px(context, 8);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(fix720px6, fix720px7);
        layoutParams4.addRule(11);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = fix720px8;
        layoutParams4.rightMargin = fix720px4;
        mCounterView = f(context);
        relativeLayout.addView(mCounterView, layoutParams4);
        return relativeLayout;
    }

    private View c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setBackgroundDrawable(DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("frame_bg")));
        ListView listView = new ListView(context);
        listView.setCacheColorHint(0);
        listView.setDivider(DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("list_divider_white")));
        SessionManager sessionManager = SessionManager.getInstance(context);
        List<MediaType> supportedMediaTypes = this.mSocialShareConfig.getSupportedMediaTypes();
        this.mShareMediaItems = new ArrayList();
        for (MediaType mediaType : supportedMediaTypes) {
            at a2 = at.a(context, mediaType);
            if (a2 != null) {
                SessionManager.Session session = sessionManager.get(mediaType.toString());
                if (session != null && !session.isExpired()) {
                    if (this.h == null || this.h == a2.a()) {
                        a2.a(true);
                    }
                    a2.b(true);
                    a2.a(session.getMediaUname());
                }
                this.mShareMediaItems.add(a2);
            }
        }
        listView.setAdapter((ListAdapter) new af(context, this.mShareMediaItems, this));
        int fix720px = DrawableUtils.fix720px(context, 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(fix720px, 0, fix720px, 0);
        linearLayout.addView(listView, layoutParams);
        return linearLayout;
    }

    private View d(Context context) {
        int fix720px = DrawableUtils.fix720px(context, 28);
        EditText editText = new EditText(context);
        editText.setTextSize(0, fix720px);
        editText.setTextColor(-13421773);
        editText.setGravity(48);
        editText.setText(this.e);
        editText.setId(3);
        editText.setBackgroundDrawable(null);
        editText.addTextChangedListener(new w(this));
        editText.setSelection(editText.length());
        editText.setOnTouchListener(new z(this, new GestureDetector(new y(this, context, editText))));
        if (this.mSocialShareConfig.getInt("content_editable") != 0) {
            editText.setEnabled(true);
        }
        return editText;
    }

    private m e(Context context) {
        GradientDrawable a2 = a(context, -1);
        GradientDrawable a3 = a(context, -3355444);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new LayerDrawable(new Drawable[]{a2, a3}));
        stateListDrawable.addState(new int[]{16842910}, a2);
        stateListDrawable.addState(new int[0], a2);
        m mVar = new m(context);
        mVar.a(this.d.getLocation());
        mVar.setBackgroundDrawable(stateListDrawable);
        mVar.setId(4);
        return mVar;
    }

    private TextView f(Context context) {
        TextView textView = new TextView(context);
        textView.setText(String.valueOf(this.mMaxLength - this.e.length()));
        textView.setTextColor(-5658199);
        textView.setTextSize(0, DrawableUtils.fix720px(context, 22));
        textView.setBackgroundDrawable(a(context, -1));
        textView.setGravity(17);
        textView.setId(5);
        return textView;
    }

    private View g(Context context) {
        Drawable drawable = DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("frame_bg"));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundDrawable(drawable);
        relativeLayout.setPadding(3, 3, 3, 3);
        relativeLayout.setId(9);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView, b);
        int fix720px = DrawableUtils.fix720px(context, 40);
        Drawable drawable2 = DrawableUtils.getDrawable(context, this.mSocialShareConfig.getAssetFileName("selected"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(fix720px, fix720px);
        layoutParams.rightMargin = 3;
        layoutParams.bottomMargin = 3;
        layoutParams.addRule(11);
        layoutParams.addRule(12);
        ImageButton imageButton = new ImageButton(context);
        imageButton.setBackgroundDrawable(drawable2);
        relativeLayout.addView(imageButton, layoutParams);
        imageButton.setVisibility(4);
        this.f = false;
        if (this.d.getImageUri() != null) {
            ImageManager.getInstance().loadImage(context, this.d.getImageUri(), new bc(this, imageView, imageButton));
        } else if (this.d.getImageData() != null) {
            imageView.setImageBitmap(this.d.getImageData());
            imageButton.setVisibility(0);
            this.f = true;
        }
        if (this.f) {
            relativeLayout.setOnClickListener(new aa(this, imageButton));
        }
        return relativeLayout;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.j instanceof Activity) {
            ((Activity) this.j).setRequestedOrientation(-1);
        }
    }

    public void doShare() {
        SocialShare socialShare = SocialShare.getInstance(getContext());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mShareMediaItems.size(); i++) {
            at atVar = (at) this.mShareMediaItems.get(i);
            if (atVar.c()) {
                arrayList.add(atVar.a().toString());
            }
        }
        if (arrayList.size() <= 0) {
            a("no_media_selected");
        } else if (arrayList.size() == 1) {
            socialShare.share(getShareContent(), (String) arrayList.get(0), this.mListener);
            dismiss();
        } else {
            socialShare.share(getShareContent(), (String[]) arrayList.toArray(new String[arrayList.size()]), this.mListener, false);
            dismiss();
        }
    }

    protected ShareContent getShareContent() {
        this.d.setContent(this.e);
        if (!this.f) {
            this.d.setImageData(null);
            this.d.setImageUri(null);
        }
        if (this.c.a()) {
            this.d.setLocation(this.c.b());
        } else {
            this.d.setLocation(null);
        }
        return this.d;
    }

    @Override // defpackage.aj
    public void onCheckStatusChanged(boolean z) {
        if (z) {
            this.mMaxLength = 80;
            a();
        } else {
            this.mMaxLength = MAX_LENGTH_FOR_OTHERS;
        }
        mCounterView.setText(String.valueOf(this.mMaxLength - this.e.length()));
    }
}
