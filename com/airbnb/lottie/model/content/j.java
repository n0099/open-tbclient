package com.airbnb.lottie.model.content;

import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
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

    @Override // com.airbnb.lottie.model.content.b
    public com.airbnb.lottie.a.a.b a(com.airbnb.lottie.g gVar, com.airbnb.lottie.model.layer.a aVar) {
        return new com.airbnb.lottie.a.a.c(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeGroup{name='" + this.name + "' Shapes: " + Arrays.toString(this.items.toArray()) + '}';
    }
}
