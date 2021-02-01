package com.baidu.tbadk.core.view.commonBtn;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.annotation.ColorRes;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public abstract class TBSpecificationButtonConfig {
    WebpType fna;
    protected int fnb;
    int fnc;
    int fnd;
    IconType fnf;
    private int fng;
    boolean fnh;
    protected a fno;
    boolean fnm = true;
    int ajU = 0;
    GradientDrawable.Orientation fnn = GradientDrawable.Orientation.LEFT_RIGHT;
    final int[] fne = new int[2];
    int fni = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fnj = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    int fnk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    int fnl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X001);
    int minWidth = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds176);
    int minHeight = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds78);
    int iconSize = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    /* loaded from: classes.dex */
    public enum IconType {
        SVG,
        WEBP,
        PIC
    }

    /* loaded from: classes.dex */
    public enum WebpType {
        MASK,
        PURE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void buS();

        void buT();

        void buU();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Drawable ak(float f);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buV() {
        return pM(this.fne[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable buW() {
        return pM(this.fne[1]);
    }

    private Drawable pM(int i) {
        Drawable drawable;
        if (this.fnf == IconType.SVG) {
            drawable = SvgManager.bsR().c(i, ap.getColor(this.ajU, this.fng > 0 ? this.fng : this.fnb), SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.fnf == IconType.WEBP) {
            if (this.fna == WebpType.MASK) {
                drawable = WebPManager.a(i, null);
            } else {
                drawable = WebPManager.a(i, ap.getColor(this.ajU, this.fng > 0 ? this.fng : this.fnb), (WebPManager.ResourceStateType) null);
            }
        } else {
            drawable = ap.getDrawable(this.ajU, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, this.iconSize, this.iconSize);
        }
        return drawable;
    }

    public void a(int i, int i2, IconType iconType) {
        if (this.fne[0] != i || this.fne[1] != i2 || this.fnf != iconType) {
            this.fne[0] = i;
            this.fne[1] = i2;
            this.fnf = iconType;
            if (this.fno != null) {
                this.fno.buT();
            }
        }
    }

    public void a(WebpType webpType) {
        this.fna = webpType;
    }

    public void setIconSize(int i) {
        if (i > 0 && this.iconSize != i) {
            this.iconSize = i;
            if (this.fno != null) {
                this.fno.buS();
            }
        }
    }

    public void pN(@ColorRes int i) {
        if (this.fng != i) {
            this.fng = i;
            if (this.fno != null) {
                this.fno.buT();
            }
        }
    }

    public void aW(int i, int i2) {
        if (i > 0) {
            this.minWidth = i;
        }
        if (i2 > 0) {
            this.minHeight = i2;
        }
    }

    public void pO(int i) {
        this.fni = i;
        this.fnj = i;
    }

    public void aX(int i, int i2) {
        this.fni = i;
        this.fnj = i2;
    }

    public void pP(int i) {
        this.fnk = i;
    }

    public void a(GradientDrawable.Orientation orientation) {
        this.fnn = orientation;
    }

    public void pQ(int i) {
        this.fnl = i;
    }
}
