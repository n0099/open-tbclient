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
/* loaded from: classes14.dex */
public class PrologueImageView extends ImageView {
    private RequestOptions cnR;
    private boolean cnS;

    public PrologueImageView(@NonNull Context context) {
        this(context, null);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cnR = null;
        this.cnS = false;
        d(attributeSet);
    }

    private void d(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.e.PrologueImageView);
            int resourceId = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_holder, 0);
            if (resourceId != 0) {
                afs();
                this.cnR = this.cnR.placeholder(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_errorHolder, 0);
            if (resourceId2 != 0) {
                afs();
                this.cnR = this.cnR.error(resourceId2);
            }
            Transformation transformation = null;
            if (obtainStyledAttributes.getBoolean(b.e.PrologueImageView_prologue_circleType, false)) {
                transformation = new a(com.baidu.prologue.a.b.a.clZ.get().aei());
            } else {
                int i = obtainStyledAttributes.getInt(b.e.PrologueImageView_prologue_cornerRadius, 0);
                if (i > 0) {
                    this.cnS = true;
                    transformation = new RoundedCorners(i);
                }
            }
            if (transformation != null) {
                afs();
                this.cnR = this.cnR.transform(transformation);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void afs() {
        if (this.cnR == null) {
            this.cnR = new RequestOptions();
        }
    }
}
