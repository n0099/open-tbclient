package com.baidu.live.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes10.dex */
public class j implements b {
    private final List<b> items;
    private final String name;

    public j(String str, List<b> list) {
        this.name = str;
        this.items = list;
    }

    public String getName() {
        return this.name;
    }

    public List<b> getItems() {
        return this.items;
    }

    @Override // com.baidu.live.lottie.model.content.b
    public com.baidu.live.lottie.a.a.b a(com.baidu.live.lottie.h hVar, com.baidu.live.lottie.model.layer.a aVar) {
        return new com.baidu.live.lottie.a.a.c(hVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
    }
}
