package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CompoundTrimPathContent {
    public List contents = new ArrayList();

    public void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, (TrimPathContent) this.contents.get(size));
        }
    }
}
