package com.baidu.cloudsdk.social.share.uiwithlayout;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
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
import com.ac;
import com.ad;
import com.ae;
import com.af;
import com.ag;
import com.baidu.cloudsdk.IBaiduListener;
import com.baidu.cloudsdk.common.util.Utils;
import com.baidu.cloudsdk.social.core.MediaType;
import com.baidu.cloudsdk.social.share.ShareContent;
import com.baidu.cloudsdk.social.share.SocialShare;
import com.baidu.cloudsdk.social.share.SocialShareConfig;
import com.p;
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
    private int g;

    /* loaded from: classes.dex */
    class a implements ViewPager.OnPageChangeListener {
        private a() {
        }

        /* synthetic */ a(ShareMenu shareMenu, ac acVar) {
            this();
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ShareMenu.this.g = i;
        }
    }

    public ShareMenu(Context context) {
        this(context, SocialShare.Theme.LIGHT, false);
    }

    public ShareMenu(Context context, SocialShare.Theme theme, boolean z) {
        super(context);
        View view;
        this.g = 0;
        setBackgroundDrawable(null);
        setWidth(-1);
        setHeight(-1);
        int F = p.F(context, "bdsocialsahre_sharemenu_animation");
        if (F != 0) {
            setAnimationStyle(F);
        }
        this.c = context;
        LayoutInflater from = LayoutInflater.from(context.getApplicationContext());
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
            this.g = 0;
            view = from.inflate(p.a(context, "bdsocialshare_sharemenulistlayout"), (ViewGroup) null);
            setContentView(view);
            ListView listView = (ListView) view.findViewById(p.d(context, "sharemenulistview"));
            if (z) {
                listView.setAdapter((ListAdapter) new ag(context, this.f));
            } else {
                listView.setAdapter((ListAdapter) new af(context, this.f));
            }
            listView.setCacheColorHint(0);
            listView.setDivider(context.getApplicationContext().getResources().getDrawable(p.b(context, "bdsocialshare_list_divider")));
            listView.setOnItemClickListener(this);
        } else {
            this.g = 0;
            int ceil = (int) Math.ceil(this.f.size() / 12.0f);
            ArrayList arrayList = new ArrayList();
            View inflate = from.inflate(p.a(context, "bdsocialshare_sharemenugridlayout"), (ViewGroup) null);
            setContentView(inflate);
            for (int i = 0; i < ceil; i++) {
                GridView gridView = new GridView(this.c);
                gridView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                gridView.setAdapter((ListAdapter) new ae(context, this.f, i));
                gridView.setCacheColorHint(0);
                gridView.setGravity(17);
                gridView.setClickable(true);
                gridView.setFocusable(true);
                gridView.setNumColumns(4);
                gridView.setOnItemClickListener(this);
                arrayList.add(gridView);
            }
            ViewPager viewPager = (ViewPager) inflate.findViewById(p.d(context, "sharemenuviewpager"));
            viewPager.setOnPageChangeListener(new a(this, null));
            viewPager.setAdapter(new ShareMenuPagerAdapter(context, arrayList));
            CirclePageIndicator circlePageIndicator = (CirclePageIndicator) inflate.findViewById(p.d(context, "sharemenuindicator"));
            if (ceil > 1) {
                circlePageIndicator.setVisibility(0);
                circlePageIndicator.setViewPager(viewPager);
                view = inflate;
            } else {
                circlePageIndicator.setVisibility(8);
                view = inflate;
            }
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(p.d(context, "sharemenulistrootlayout"));
        setFocusable(true);
        relativeLayout.setOnClickListener(this);
        relativeLayout.setFocusableInTouchMode(true);
        relativeLayout.setOnKeyListener(new ac(this));
        ((LinearLayout) view.findViewById(p.d(context, "sharemenulistlinearlayout"))).setBackgroundColor(Color.parseColor(p.b(context)));
        ((RelativeLayout) view.findViewById(p.d(context, "sharemenulistcancelbar"))).setBackgroundResource(p.b(context, "bdsocialshare_cancelbar_bg"));
        this.e = p.d(context, "sharemenulistcancelbutton");
        Button button = (Button) view.findViewById(this.e);
        button.setText(SocialShareConfig.getInstance(context).getString("cancel"));
        button.setTextColor(Color.parseColor(p.c(context)));
        button.setBackgroundResource(p.b(context, "bdsocialshare_sharemenu_cancelbutton"));
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
        SocialShare.getInstance(this.c).share(this.a, ((MediaType) this.f.get((this.g * 12) + i)).toString(), (IBaiduListener) new ad(this, this.b), true);
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
