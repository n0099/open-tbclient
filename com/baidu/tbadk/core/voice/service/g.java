package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class g implements Runnable {
    final /* synthetic */ MyAudioRecorder afE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyAudioRecorder myAudioRecorder) {
        this.afE = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afE.vH();
    }
}
