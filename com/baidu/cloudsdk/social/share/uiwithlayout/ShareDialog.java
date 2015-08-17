package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.assets.DrawableUtils;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.core.SessionManager;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.baidu.tbadk.TbConfig;
import com.p;
import com.t;
import com.u;
import com.v;
import com.w;
import com.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ShareDialog extends Dialog implements View.OnClickListener, x.a {
    protected static final int MAX_LENGTH_FOR_QZONE = 80;
    private static final String a = ShareDialog.class.getSimpleName();
    private IBaiduListener b;
    private int c;
    private int d;
    private SocialShareConfig e;
    private List f;
    private CheckImageView g;
    private LocationPreview h;
    private TextView i;
    private MediaType j;
    private ShareContent k;
    private int l;
    private EditText m;
    public int mMaxLength;
    private boolean n;
    private Activity o;
    private LinearLayout p;

    public ShareDialog(Context context, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this(context, shareContent, null, iBaiduListener);
    }

    public ShareDialog(Context context, ShareContent shareContent, MediaType mediaType, IBaiduListener iBaiduListener) {
        super(context, 16973830);
        this.l = -1;
        if (context instanceof Activity) {
            this.o = (Activity) context;
            this.l = this.o.getRequestedOrientation();
            this.o.setRequestedOrientation(1);
        }
        setContentView(LayoutInflater.from(context.getApplicationContext()).inflate(p.a(context, "bdsocialshare_sharedialoglayout"), (ViewGroup) null));
        this.p = (LinearLayout) findViewById(p.s(context, "sharedialog_rootlayout"));
        this.p.setBackgroundColor(Color.parseColor(p.d(context)));
        this.b = iBaiduListener;
        this.j = mediaType;
        this.k = shareContent;
        this.e = SocialShareConfig.getInstance(context);
        this.n = this.e.getInt("use_toast_tip") != 0;
        a(context.getApplicationContext());
        c(context.getApplicationContext());
        b(context.getApplicationContext());
        getWindow().setBackgroundDrawable(null);
        getWindow().setSoftInputMode(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        this.i.setText(String.valueOf(i));
        if (i <= 10) {
            this.i.setTextColor(SupportMenu.CATEGORY_MASK);
        } else {
            this.i.setTextColor(Color.parseColor(p.h(getContext())));
        }
    }

    private void a(Context context) {
        this.d = p.s(context, "sharedialog_button_cancel");
        this.c = p.s(context, "sharedialog_button_share");
        ((RelativeLayout) findViewById(p.s(context, "sharedialog_titlebar"))).setBackgroundResource(p.b(context, "bdsocialshare_titlebar_bg"));
        int b = p.b(context, "bdsocialshare_sharedialog_button");
        Button button = (Button) findViewById(this.d);
        button.setText(this.e.getString("cancel"));
        button.setTextColor(Color.parseColor(p.e(context)));
        button.setBackgroundResource(b);
        Button button2 = (Button) findViewById(this.c);
        button2.setText(this.e.getString(TbConfig.TMP_SHARE_DIR_NAME));
        button2.setTextColor(Color.parseColor(p.e(context)));
        button2.setBackgroundResource(b);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        TextView textView = (TextView) findViewById(p.s(context, "sharedialog_textview_title"));
        textView.setTextColor(Color.parseColor(p.f(context)));
        textView.setText(this.e.getString("sharecontent"));
    }

    private void a(String str) {
        if (this.n) {
            Toast.makeText(getContext(), this.e.getString(str), 0).show();
        } else {
            new AlertDialog.Builder(getContext()).setTitle(this.e.getString("tip_title")).setMessage(this.e.getString(str)).setPositiveButton(this.e.getString("confirm"), (DialogInterface.OnClickListener) null).show();
        }
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext().getApplicationContext()).inflate(p.a(getContext(), "bdsocialshare_sharedialogtoastlayout"), (ViewGroup) null);
        inflate.setBackgroundResource(p.b(getContext(), "bdsocialshare_tip_words"));
        ((TextView) inflate.findViewById(p.s(getContext(), "sharedialog_toasttext"))).setText(this.e.getString("qzone_limit_tip"));
        Toast toast = new Toast(getContext());
        toast.setGravity(53, DrawableUtils.fix720px(getContext(), 66), DrawableUtils.fix720px(getContext(), 456));
        toast.setView(inflate);
        toast.setDuration(1000);
        toast.show();
    }

    private void b(Context context) {
        ((RelativeLayout) findViewById(p.s(context, "sharedialog_contentlayout"))).setBackgroundResource(p.b(context, "bdsocialshare_editor_bg"));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(p.s(context, "sharedialog_imagepreview"));
        if (this.k.getImageData() == null && this.k.getImageUri() == null) {
            relativeLayout.setVisibility(8);
        } else {
            this.g = (CheckImageView) findViewById(p.s(context, "sharedialog_checkimage"));
            this.g.setClickable(true);
            if (this.k.getImageUri() != null) {
                ImageManager.getInstance().loadImage(context, this.k.getImageUri(), new t(this, relativeLayout));
            } else if (this.k.getImageData() != null) {
                this.g.setImageBitmap(this.k.getImageData());
                this.g.setChecked(true);
            }
        }
        this.m = (EditText) findViewById(p.s(context, "sharedialog_edittext_content"));
        this.m.setTextColor(Color.parseColor(p.g(context)));
        this.m.setText(this.k.getContent());
        this.m.setBackgroundDrawable(null);
        this.m.addTextChangedListener(new u(this));
        if (this.m.length() > 0) {
            this.m.setSelection(this.m.length());
        }
        this.m.setOnTouchListener(new w(this, new GestureDetector(new v(this))));
        if (this.e.getInt("content_editable") != 0) {
            this.m.setEnabled(true);
        }
        this.i = (TextView) findViewById(p.s(context, "sharedialog_textcounter"));
        this.i.setBackgroundResource(p.b(context, "bdsocialshare_sharedialog_counter_bg"));
        a(this.mMaxLength - this.m.length());
        this.h = (LocationPreview) findViewById(p.s(context, "sharedialog_locationpreview"));
        this.h.setBackgroundResource(p.b(context, "bdsocialshare_sharedialog_locationpreview_bg"));
        if (this.e.getInt("location_enable") == 1) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    private void c() {
        int i = 140;
        Iterator it = this.f.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                this.mMaxLength = i2;
                return;
            } else {
                ShareMediaItem shareMediaItem = (ShareMediaItem) it.next();
                i = shareMediaItem.isChecked() ? Math.min(i2, shareMediaItem.getLimitCount()) : i2;
            }
        }
    }

    private void c(Context context) {
        ListView listView = (ListView) findViewById(p.s(context, "sharedialog_medialistview"));
        listView.setCacheColorHint(0);
        listView.setBackgroundResource(p.b(context, "bdsocialshare_frame_bg"));
        listView.setDivider(context.getApplicationContext().getResources().getDrawable(p.b(context, "bdsocialshare_list_divider")));
        SessionManager sessionManager = SessionManager.getInstance(context);
        List<MediaType> supportedMediaTypes = this.e.getSupportedMediaTypes();
        this.f = new ArrayList();
        for (MediaType mediaType : supportedMediaTypes) {
            ShareMediaItem create = ShareMediaItem.create(context, mediaType);
            if (create != null) {
                SessionManager.Session session = sessionManager.get(mediaType.toString());
                if (session != null && !session.isExpired()) {
                    if (this.j == null || this.j == create.getMediaType()) {
                        create.setChecked(true);
                        if (create.getMediaType() == MediaType.QZONE) {
                            b();
                        }
                    }
                    create.setAuthorized(true);
                    create.setUserName(session.getMediaUname());
                }
                this.f.add(create);
            }
        }
        listView.setAdapter((ListAdapter) new x(context, this.f, this));
        c();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (this.g != null) {
            this.g.setImageBitmap(null);
            this.g.destroyDrawingCache();
        }
        if (this.m != null) {
            this.m.setFocusable(false);
            this.m = null;
        }
        if (this.h != null) {
            this.h.setFocusable(false);
            this.h.setClickable(false);
            this.h.destroyDrawingCache();
            this.h = null;
        }
        if (this.o != null) {
            this.o.setRequestedOrientation(this.l);
            this.o = null;
        }
        if (this.p != null) {
            this.p.removeAllViews();
            this.p.destroyDrawingCache();
            this.p = null;
        }
    }

    protected void doShare() {
        SocialShare socialShare = SocialShare.getInstance(getContext());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f.size(); i++) {
            ShareMediaItem shareMediaItem = (ShareMediaItem) this.f.get(i);
            if (shareMediaItem.isChecked()) {
                arrayList.add(shareMediaItem.getMediaType().toString());
            }
        }
        if (arrayList.size() <= 0) {
            a("no_media_selected");
        } else if (arrayList.size() == 1) {
            socialShare.share(getShareContent(), (String) arrayList.get(0), this.b);
            dismiss();
        } else {
            socialShare.share(getShareContent(), (String[]) arrayList.toArray(new String[arrayList.size()]), this.b, false);
            dismiss();
        }
    }

    protected ShareContent getShareContent() {
        this.k.setContent(this.m.getText().toString());
        if (this.g != null && !this.g.isChecked()) {
            this.k.setImageData(null);
            this.k.setImageUri(null);
        }
        if (this.e.getInt("location_enable") == 1) {
            if (this.h == null || !this.h.isChecked()) {
                this.k.setLocation(null);
            } else {
                this.k.setLocation(this.h.getLocation());
            }
        }
        return this.k;
    }

    @Override // com.x.a
    public void onCheckStatusChanged(boolean z, MediaType mediaType) {
        c();
        if (z && mediaType == MediaType.QZONE) {
            b();
        }
        a(this.mMaxLength - this.m.length());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.d) {
            dismiss();
            if (this.b != null) {
                this.b.onCancel();
            }
        } else if (view.getId() == this.c) {
            if (TextUtils.isEmpty(this.m.getText())) {
                a("share_content_empty");
            } else if (this.mMaxLength - this.m.length() >= 0) {
                doShare();
            } else {
                a("share_content_exceed");
            }
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        int t = p.t(getContext(), "bdsocialshare_sharedialog_animation");
        if (t != 0) {
            getWindow().setWindowAnimations(t);
        }
        int i = this.e.getInt("activity_brightness");
        if (i > 0) {
            Utils.setBrightness(this, i);
        }
    }
}
