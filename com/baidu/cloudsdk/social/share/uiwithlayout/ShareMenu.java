package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.aq;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.bc;
import com.bd;
import com.be;
import com.bf;
import com.bg;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ShareMenu extends PopupWindow implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ShareContent a;
    private IBaiduListener b;
    private Context c;
    private RelativeLayout d;
    private int e;
    private List f;

    public ShareMenu(Context context) {
        this(context, SocialShare.Theme.LIGHT, false);
    }

    public ShareMenu(Context context, SocialShare.Theme theme, boolean z) {
        super(context);
        View inflate;
        setBackgroundDrawable(new BitmapDrawable());
        setWidth(-1);
        setHeight(-1);
        int e = aq.e(context, "bdsocialsahre_sharemenu_animation");
        if (e != 0) {
            setAnimationStyle(e);
        }
        this.c = context;
        LayoutInflater from = LayoutInflater.from(context);
        if (z) {
            this.f = new ArrayList();
            this.f.add(MediaType.WEIXIN_FRIEND);
            this.f.add(MediaType.WEIXIN_TIMELINE);
        } else {
            this.f = SocialShareConfig.getInstance(context).getSupportedMediaTypes();
            for (MediaType mediaType : SocialShareConfig.getInstance(context).getExcludedMediaTypesInShareMenu()) {
                this.f.remove(mediaType);
            }
        }
        if (Utils.isEmpty(this.f)) {
            throw new IllegalArgumentException("config item for [supported_medias] shouldn't be empty");
        }
        if (this.f.size() < 5) {
            inflate = from.inflate(aq.a(context, "bdsocialshare_sharemenulistlayout"), (ViewGroup) null);
            setContentView(inflate);
            ListView listView = (ListView) inflate.findViewById(aq.d(context, "sharemenulistview"));
            if (z) {
                listView.setAdapter((ListAdapter) new bg(context, this.f));
            } else {
                listView.setAdapter((ListAdapter) new bf(context, this.f));
            }
            listView.setCacheColorHint(0);
            listView.setDivider(context.getApplicationContext().getResources().getDrawable(aq.b(context, "bdsocialshare_list_divider")));
            listView.setOnItemClickListener(this);
        } else {
            inflate = from.inflate(aq.a(context, "bdsocialshare_sharemenugridlayout"), (ViewGroup) null);
            setContentView(inflate);
            GridView gridView = (GridView) inflate.findViewById(aq.d(context, "sharemenugridview"));
            gridView.setAdapter((ListAdapter) new be(context, this.f));
            gridView.setCacheColorHint(0);
            gridView.setOnItemClickListener(this);
        }
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(aq.d(context, "sharemenulistrootlayout"));
        setFocusable(true);
        relativeLayout.setOnClickListener(this);
        relativeLayout.setFocusableInTouchMode(true);
        relativeLayout.setOnKeyListener(new bc(this));
        ((LinearLayout) inflate.findViewById(aq.d(context, "sharemenulistlinearlayout"))).setBackgroundColor(Color.parseColor(aq.b(context)));
        ((RelativeLayout) inflate.findViewById(aq.d(context, "sharemenulistcancelbar"))).setBackgroundResource(aq.b(context, "bdsocialshare_cancelbar_bg"));
        this.e = aq.d(context, "sharemenulistcancelbutton");
        Button button = (Button) inflate.findViewById(this.e);
        button.setText(SocialShareConfig.getInstance(context).getString("cancel"));
        button.setTextColor(Color.parseColor(aq.c(context)));
        button.setBackgroundResource(aq.b(context, "bdsocialshare_sharemenu_cancelbutton"));
        button.setOnClickListener(this);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        setFocusable(false);
        if (this.d != null) {
            this.d.removeAllViews();
            this.d.destroyDrawingCache();
            this.d = null;
        }
        this.c = null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.e) {
            dismiss();
            if (this.b != null) {
                this.b.onCancel();
                return;
            }
            return;
        }
        dismiss();
        if (this.b != null) {
            this.b.onCancel();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        SocialShare.getInstance(this.c).share(this.a, ((MediaType) this.f.get(i)).toString(), (IBaiduListener) new bd(this, this.b), true);
        dismiss();
    }

    public void setContext(Context context) {
        this.c = context;
    }

    public void show(View view, ShareContent shareContent, IBaiduListener iBaiduListener) {
        this.a = shareContent;
        this.b = iBaiduListener;
        showAtLocation(view, 81, 0, 0);
    }
}
