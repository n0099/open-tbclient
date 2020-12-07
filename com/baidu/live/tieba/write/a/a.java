package com.baidu.live.tieba.write.a;

import android.annotation.SuppressLint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.album.AlbumData;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tieba.write.album.AlbumActivity;
import com.baidu.live.tieba.write.album.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends PopupWindow {
    private AlbumActivity bIZ;
    private View bJa;
    private ViewGroup bJb;
    private b bJc;
    private int bJd;
    private InterfaceC0227a bJe;
    private ListView mListView;
    private final View.OnClickListener mOnClickListener;
    private final AdapterView.OnItemClickListener mOnItemClickListener;

    /* renamed from: com.baidu.live.tieba.write.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0227a {
        void a(int i, AlbumData albumData);
    }

    public void a(InterfaceC0227a interfaceC0227a) {
        this.bJe = interfaceC0227a;
    }

    public a(AlbumActivity albumActivity) {
        super(albumActivity.getPageContext().getPageActivity());
        this.mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.live.tieba.write.a.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AlbumData item = a.this.bJc.getItem(i);
                if (a.this.bJe != null) {
                    a.this.bJe.a(i, item);
                }
                a.this.Wd();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.live.tieba.write.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.Wd();
            }
        };
        this.bIZ = albumActivity;
        setWidth(-1);
        setHeight(-1);
        setContentView(d(new ArrayList(), AlbumData.ALBUM_ID_ALL));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setAnimationStyle(0);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    @SuppressLint({"ResourceAsColor"})
    private View d(List<AlbumData> list, String str) {
        BdListView bdListView = new BdListView(this.bIZ.getPageContext().getPageActivity());
        this.mListView = bdListView;
        bdListView.setCacheColorHint(this.bIZ.getResources().getColor(17170445));
        bdListView.setDivider(null);
        bdListView.setDividerHeight(0);
        bdListView.setFadingEdgeLength(0);
        this.bJc = new b(this.bIZ);
        this.bJc.c(list, str);
        bdListView.setAdapter((ListAdapter) this.bJc);
        FrameLayout frameLayout = new FrameLayout(this.bIZ.getPageContext().getPageActivity());
        FrameLayout frameLayout2 = new FrameLayout(this.bIZ.getPageContext().getPageActivity());
        this.bJb = frameLayout2;
        frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(bdListView, new FrameLayout.LayoutParams(-1, -2));
        this.mListView.setOnItemClickListener(this.mOnItemClickListener);
        this.bJb.setOnClickListener(this.mOnClickListener);
        SkinManager.setBackgroundColor(this.bJa, a.c.sdk_cp_bg_line_d);
        SkinManager.setBackgroundColor(this.mListView, a.c.sdk_cp_bg_line_d);
        SkinManager.setBackgroundColor(this.bJb, a.c.sdk_black_alpha70);
        return frameLayout;
    }

    public void c(List<AlbumData> list, String str) {
        int i;
        if (list != null) {
            this.bJd = e(list, str);
            if (list.size() <= 5) {
                i = -2;
            } else {
                i = this.bIZ.getResources().getDimensionPixelSize(a.d.sdk_ds618);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mListView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, i);
            } else {
                layoutParams.height = i;
            }
            this.mListView.setLayoutParams(layoutParams);
            this.bJc.c(list, str);
            this.bJc.notifyDataSetChanged();
        }
    }

    private int e(List<AlbumData> list, String str) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AlbumData albumData = list.get(i);
            if (albumData != null && str.equals(albumData.getAlbumId())) {
                return i;
            }
        }
        return -1;
    }

    public void O(View view) {
        this.mListView.setSelection(this.bJd);
        if (Build.VERSION.SDK_INT < 24) {
            if (ShowUtil.showPopupWindowAsDropDown(this, view)) {
                Wf();
                return;
            }
            return;
        }
        if (ShowUtil.showPopupWindowAtLocation(this, view, 0, 0, ((this.bIZ.Vv() == null || this.bIZ.Vv().getVisibility() != 0) ? 0 : this.bIZ.Vv().getHeight()) + view.getHeight())) {
            Wf();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Wd();
    }

    public void Wd() {
        Wg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We() {
        super.dismiss();
    }

    private void Wf() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        this.mListView.startAnimation(translateAnimation);
        this.bJb.startAnimation(alphaAnimation);
    }

    private void Wg() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(350L);
        translateAnimation.setFillAfter(true);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(350L);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.live.tieba.write.a.a.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                a.this.We();
            }
        });
        this.mListView.startAnimation(translateAnimation);
        this.bJb.startAnimation(alphaAnimation);
    }

    public void clearAnimation() {
        if (this.mListView != null) {
            this.mListView.clearAnimation();
        }
        if (this.bJb != null) {
            this.bJb.clearAnimation();
        }
    }
}
