package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TransitionValues {

    /* renamed from: view  reason: collision with root package name */
    public View f1029view;
    public final Map<String, Object> values = new HashMap();
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public int hashCode() {
        return (this.f1029view.hashCode() * 31) + this.values.hashCode();
    }

    public TransitionValues(@NonNull View view2) {
        this.f1029view = view2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TransitionValues) {
            TransitionValues transitionValues = (TransitionValues) obj;
            if (this.f1029view == transitionValues.f1029view && this.values.equals(transitionValues.values)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f1029view + "\n") + "    values:";
        for (String str2 : this.values.keySet()) {
            str = str + "    " + str2 + ": " + this.values.get(str2) + "\n";
        }
        return str;
    }
}
