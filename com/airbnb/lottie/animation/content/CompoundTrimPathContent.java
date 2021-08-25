package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class CompoundTrimPathContent {
    public List<TrimPathContent> contents = new ArrayList();

    public void addTrimPath(TrimPathContent trimPathContent) {
        this.contents.add(trimPathContent);
    }

    public void apply(Path path) {
        for (int size = this.contents.size() - 1; size >= 0; size--) {
            Utils.applyTrimPathIfNeeded(path, this.contents.get(size));
        }
    }
}
