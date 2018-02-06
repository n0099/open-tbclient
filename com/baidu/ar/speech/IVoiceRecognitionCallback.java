package com.baidu.ar.speech;
/* loaded from: classes3.dex */
public interface IVoiceRecognitionCallback {
    void onIntermediateResultChange(String str, String str2);

    void onMicNoPermissionButtonClick(MMSMicrophoneNoPermissionButtonClickType mMSMicrophoneNoPermissionButtonClickType);

    void onMicRelease();

    void onRecognitionFail(String str);

    void onRecognitionSuccess(String str);

    void onVoiceRecogniitonCancel();

    void onVoiceRecognitionStarted();

    void onVoiceRecordData(byte[] bArr);

    void onVoiceRecordStarted();

    void onVolumeChange(double d);
}
