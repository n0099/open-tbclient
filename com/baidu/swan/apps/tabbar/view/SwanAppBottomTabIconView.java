package com.baidu.swan.apps.tabbar.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class SwanAppBottomTabIconView extends RelativeLayout {
    public ImageView a;
    public TextView b;
    public ImageView c;
    public TextView d;
    public boolean e;

    public SwanAppBottomTabIconView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d009e, (ViewGroup) this, true);
        this.a = (ImageView) findViewById(R.id.obfuscated_res_0x7f090482);
        this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090484);
        this.c = (ImageView) findViewById(R.id.obfuscated_res_0x7f090483);
        this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090481);
    }

    public boolean a() {
        return this.e;
    }

    public void setBadgeText(String str) {
        this.d.setText(str);
    }

    public void setBadgeVisibleState(boolean z) {
        if (z) {
            this.d.setVisibility(0);
        } else {
            this.d.setVisibility(8);
        }
    }

    public void setIconView(int i) {
        this.a.setImageDrawable(getResources().getDrawable(i));
    }

    public void setRedDotVisibleState(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public void setTextColor(int i) {
        this.b.setTextColor(i);
    }

    public void setTextView(String str) {
        this.b.setText(str);
    }

    public void setmIsSelect(boolean z) {
        this.e = z;
    }

    public void setIconView(Bitmap bitmap) {
        this.a.setImageBitmap(bitmap);
    }

    public void setIconView(Drawable drawable) {
        this.a.setImageDrawable(drawable);
    }
}
