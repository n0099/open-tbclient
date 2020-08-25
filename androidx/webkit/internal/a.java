package androidx.webkit.internal;
/* loaded from: classes4.dex */
public class a implements e {
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    @Override // androidx.webkit.internal.e
    public org.a.a.d hM() {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }

    @Override // androidx.webkit.internal.e
    public String[] hN() {
        return EMPTY_STRING_ARRAY;
    }
}
