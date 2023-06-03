package com.baidu.searchbox.player.model;

import kotlin.Metadata;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0002J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/player/model/FloatRange;", "Lcom/baidu/searchbox/player/model/Range;", "", "range", "", "(Ljava/lang/String;)V", "contains", "", "value", "parseValue", "content", "(Ljava/lang/String;)Ljava/lang/Float;", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FloatRange extends Range<Float> {
    public FloatRange(String str) {
        super(str);
    }

    public boolean contains(float f) {
        float f2;
        float f3;
        Float max = getMax();
        if (max != null) {
            f2 = max.floatValue();
        } else {
            f2 = Float.MAX_VALUE;
        }
        Float min = getMin();
        if (min != null) {
            f3 = min.floatValue();
        } else {
            f3 = Float.MIN_VALUE;
        }
        if (f >= f3 && f < f2) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.player.model.Range
    public Float parseValue(String str) {
        if (str != null) {
            return StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str);
        }
        return null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.searchbox.player.model.Range
    public /* bridge */ /* synthetic */ boolean contains(Float f) {
        return contains(f.floatValue());
    }
}
