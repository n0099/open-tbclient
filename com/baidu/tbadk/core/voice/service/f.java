package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class f implements Runnable {
    final /* synthetic */ MyAudioRecorder Jl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(MyAudioRecorder myAudioRecorder) {
        this.Jl = myAudioRecorder;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Jl.nK();
    }
}
