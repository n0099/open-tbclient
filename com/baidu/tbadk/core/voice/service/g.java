package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ MyAudioRecorder ajl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyAudioRecorder myAudioRecorder) {
        this.ajl = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ajl.wW();
    }
}
