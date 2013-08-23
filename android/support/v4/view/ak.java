package android.support.v4.view;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;
/* loaded from: classes.dex */
class ak extends SingleLineTransformationMethod {

    /* renamed from: a  reason: collision with root package name */
    private Locale f316a;

    public ak(Context context) {
        this.f316a = context.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(this.f316a);
        }
        return null;
    }
}
