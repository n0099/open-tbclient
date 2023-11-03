package com.baidu.searchbox.permission.popupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.skin.ioc.ISkinResourcesContext;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import com.baidu.tieba.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00102\b\b\u0001\u0010\u0015\u001a\u00020\u0013J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\"\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0016J*\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/baidu/searchbox/permission/popupwindow/PermissionInAppWindow;", "Lcom/baidu/android/ext/widget/PopupWindow;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mContentView", "Landroid/widget/TextView;", "mContext", "mPermissionRootView", "Landroid/widget/LinearLayout;", "mTitleView", "getOffSetY", "", NotificationCompat.WearableExtender.KEY_GRAVITY, "y", "init", "", "setContentText", "content", "", "setTitleText", "title", "showAsDropDown", "anchor", "Landroid/view/View;", "xoff", "yoff", "showAtLocation", "parent", "x", "updateUI", "lib-oem-permission_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PermissionInAppWindow extends PopupWindow {
    public TextView mContentView;
    public Context mContext;
    public LinearLayout mPermissionRootView;
    public TextView mTitleView;

    public PermissionInAppWindow(Context context) {
        super(context);
        init(context);
    }

    public final void setContentText(@NonNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setText(content);
        }
    }

    public final void setTitleText(@NonNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(title);
        }
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAsDropDown(View view2) {
        if (view2 == null) {
            return;
        }
        super.showAsDropDown(view2);
    }

    private final int getOffSetY(int i, int i2) {
        if (i == 48) {
            return i2 + DeviceUtils.ScreenInfo.getStatusBarHeight();
        }
        return i2;
    }

    private final void init(Context context) {
        if (context == null) {
            return;
        }
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d07db, (ViewGroup) null);
        setContentView(inflate);
        setWidth(-1);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.obfuscated_res_0x7f1003fa);
        this.mTitleView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091c08);
        this.mContentView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091c01);
        this.mPermissionRootView = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091c07);
        updateUI(context);
    }

    private final void updateUI(Context context) {
        Resources resources;
        ISkinResourcesContext skinResourceContext = SkinResourcesRuntime.getSkinResourceContext();
        if (skinResourceContext != null) {
            resources = skinResourceContext.getSkinResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            resources = context.getResources();
        }
        if (resources == null) {
            return;
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(ResourcesCompat.getColor(resources, R.color.obfuscated_res_0x7f0601ff, null));
        }
        TextView textView2 = this.mContentView;
        if (textView2 != null) {
            textView2.setTextColor(ResourcesCompat.getColor(resources, R.color.obfuscated_res_0x7f0601ff, null));
        }
        LinearLayout linearLayout = this.mPermissionRootView;
        if (linearLayout != null) {
            linearLayout.setBackground(ResourcesCompat.getDrawable(resources, R.drawable.obfuscated_res_0x7f0813eb, null));
        }
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAsDropDown(View view2, int i, int i2) {
        if (view2 == null) {
            return;
        }
        super.showAsDropDown(view2, i, i2);
    }

    @Override // com.baidu.android.ext.widget.PopupWindow
    public void showAtLocation(View view2, int i, int i2, int i3) {
        if (view2 == null) {
            return;
        }
        try {
            super.showAtLocation(view2, i, i2, getOffSetY(i, i3));
        } catch (Exception e) {
            if (AppConfig.isDebug()) {
                e.printStackTrace();
            }
        }
    }
}
