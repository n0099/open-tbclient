package androidx.constraintlayout.solver.widgets;
/* loaded from: classes.dex */
public class ResolutionDimension extends ResolutionNode {
    public float value = 0.0f;

    public void remove() {
        this.state = 2;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void reset() {
        super.reset();
        this.value = 0.0f;
    }

    public void resolve(int i) {
        if (this.state == 0 || this.value != i) {
            this.value = i;
            if (this.state == 1) {
                invalidate();
            }
            didResolve();
        }
    }
}
