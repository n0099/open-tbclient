package aegon.chrome.net;
/* loaded from: classes3.dex */
public abstract class UploadDataSink {
    public abstract void onReadError(Exception exc);

    public abstract void onReadSucceeded(boolean z);

    public abstract void onRewindSucceeded();
}
