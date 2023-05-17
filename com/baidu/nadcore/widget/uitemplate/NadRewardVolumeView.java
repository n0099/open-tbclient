package com.baidu.nadcore.widget.uitemplate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class NadRewardVolumeView extends AdImageView {
    public boolean d;
    public b e;

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            NadRewardVolumeView nadRewardVolumeView = NadRewardVolumeView.this;
            nadRewardVolumeView.setVolumeState(!nadRewardVolumeView.d);
            if (NadRewardVolumeView.this.e != null) {
                NadRewardVolumeView.this.e.a(NadRewardVolumeView.this.d);
            }
        }
    }

    public NadRewardVolumeView(@NonNull Context context) {
        this(context, null);
    }

    public void setVolumeListener(b bVar) {
        this.e = bVar;
    }

    public void setVolumeState(boolean z) {
        int i;
        this.d = z;
        if (z) {
            i = R.drawable.nad_player_mute_open;
        } else {
            i = R.drawable.nad_player_mute_close;
        }
        setImageDrawable(getContext().getResources().getDrawable(i));
        invalidate();
    }

    public NadRewardVolumeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NadRewardVolumeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = false;
        init();
    }

    public final void init() {
        setVolumeState(this.d);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setOnClickListener(new a());
    }
}
