package com.baidu.prologue.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.baidu.prologue.b;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes6.dex */
public class PrologueImageView extends ImageView {
    private RequestOptions btF;
    private boolean btG;

    public PrologueImageView(@NonNull Context context) {
        this(context, null);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btF = null;
        this.btG = false;
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.e.PrologueImageView);
            int resourceId = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_holder, 0);
            if (resourceId != 0) {
                Mt();
                this.btF = this.btF.placeholder(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_errorHolder, 0);
            if (resourceId2 != 0) {
                Mt();
                this.btF = this.btF.error(resourceId2);
            }
            Transformation transformation = null;
            if (obtainStyledAttributes.getBoolean(b.e.PrologueImageView_prologue_circleType, false)) {
                transformation = new a(com.baidu.prologue.a.b.a.brQ.get().Lh());
            } else {
                int i = obtainStyledAttributes.getInt(b.e.PrologueImageView_prologue_cornerRadius, 0);
                if (i > 0) {
                    this.btG = true;
                    transformation = new RoundedCorners(i);
                }
            }
            if (transformation != null) {
                Mt();
                this.btF = this.btF.transform(transformation);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void Mt() {
        if (this.btF == null) {
            this.btF = new RequestOptions();
        }
    }
}
