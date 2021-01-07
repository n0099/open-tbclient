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
/* loaded from: classes6.dex */
public class PrologueImageView extends ImageView {
    private RequestOptions cuY;
    private boolean cuZ;

    public PrologueImageView(@NonNull Context context) {
        this(context, null);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrologueImageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cuY = null;
        this.cuZ = false;
        h(attributeSet);
    }

    private void h(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, b.e.PrologueImageView);
            int resourceId = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_holder, 0);
            if (resourceId != 0) {
                ahp();
                this.cuY = this.cuY.placeholder(resourceId);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(b.e.PrologueImageView_prologue_errorHolder, 0);
            if (resourceId2 != 0) {
                ahp();
                this.cuY = this.cuY.error(resourceId2);
            }
            BitmapTransformation bitmapTransformation = null;
            if (obtainStyledAttributes.getBoolean(b.e.PrologueImageView_prologue_circleType, false)) {
                bitmapTransformation = new a(com.baidu.prologue.a.b.a.ctd.get().agf());
            } else {
                int i = obtainStyledAttributes.getInt(b.e.PrologueImageView_prologue_cornerRadius, 0);
                if (i > 0) {
                    this.cuZ = true;
                    bitmapTransformation = new RoundedCorners(i);
                }
            }
            if (bitmapTransformation != null) {
                ahp();
                this.cuY = this.cuY.transform(bitmapTransformation);
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void ahp() {
        if (this.cuY == null) {
            this.cuY = new RequestOptions();
        }
    }
}
