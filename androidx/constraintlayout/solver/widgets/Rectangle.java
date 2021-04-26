package androidx.constraintlayout.solver.widgets;
/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;
    public int x;
    public int y;

    public boolean contains(int i2, int i3) {
        int i4;
        int i5 = this.x;
        return i2 >= i5 && i2 < i5 + this.width && i3 >= (i4 = this.y) && i3 < i4 + this.height;
    }

    public int getCenterX() {
        return (this.x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void grow(int i2, int i3) {
        this.x -= i2;
        this.y -= i3;
        this.width += i2 * 2;
        this.height += i3 * 2;
    }

    public boolean intersects(Rectangle rectangle) {
        int i2;
        int i3;
        int i4 = this.x;
        int i5 = rectangle.x;
        return i4 >= i5 && i4 < i5 + rectangle.width && (i2 = this.y) >= (i3 = rectangle.y) && i2 < i3 + rectangle.height;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        this.x = i2;
        this.y = i3;
        this.width = i4;
        this.height = i5;
    }
}
