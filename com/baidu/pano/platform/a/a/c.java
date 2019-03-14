package com.baidu.pano.platform.a.a;

import java.util.Comparator;
/* loaded from: classes5.dex */
final class c implements Comparator<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(byte[] bArr, byte[] bArr2) {
        return bArr.length - bArr2.length;
    }
}
