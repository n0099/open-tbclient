package com.baidu.live.tieba.view.bubbleview;
/* loaded from: classes4.dex */
public enum ArrowDirection {
    LEFT(0),
    RIGHT(1),
    TOP(2),
    BOTTOM(3);
    
    private int value;

    ArrowDirection(int i) {
        this.value = i;
    }

    public static ArrowDirection fromInt(int i) {
        ArrowDirection[] values;
        for (ArrowDirection arrowDirection : values()) {
            if (i == arrowDirection.getValue()) {
                return arrowDirection;
            }
        }
        return LEFT;
    }

    public int getValue() {
        return this.value;
    }
}
