package com.baidu.prologue.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.prologue.b;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes5.dex */
public class PrologueImageView extends ImageView {
    private RequestOptions cqg;
    private boolean cqh;

    public PrologueImageView(@NonNull Context context) {
        this(context, null);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqg = null;
        this.cqh = false;
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.e.PrologueImageView);
            int resourceId = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_holder, 0);
            if (resourceId != 0) {
                adv();
                this.cqg = this.cqg.placeholder(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_errorHolder, 0);
            if (resourceId2 != 0) {
                adv();
                this.cqg = this.cqg.error(resourceId2);
            }
            BitmapTransformation bitmapTransformation = null;
            if (obtainStyledAttributes.getBoolean(b.e.PrologueImageView_prologue_circleType, false)) {
                bitmapTransformation = new a(com.baidu.prologue.a.b.a.cop.get().acl());
            } else {
                int i = obtainStyledAttributes.getInt(b.e.PrologueImageView_prologue_cornerRadius, 0);
                if (i > 0) {
                    this.cqh = true;
                    bitmapTransformation = new RoundedCorners(i);
                }
            }
            if (bitmapTransformation != null) {
                adv();
                this.cqg = this.cqg.transform(bitmapTransformation);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void adv() {
        if (this.cqg == null) {
            this.cqg = new RequestOptions();
        }
    }
}
