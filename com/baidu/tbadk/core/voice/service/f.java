package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MyAudioRecorder a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyAudioRecorder myAudioRecorder) {
        this.a = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.i();
    }
}
