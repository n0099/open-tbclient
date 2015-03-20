package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ MyAudioRecorder aaa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MyAudioRecorder myAudioRecorder) {
        this.aaa = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aaa.tZ();
    }
}
